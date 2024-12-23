import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[12];
    static Deque<Integer> dq = new ArrayDeque<>();
    static int flag = 0;
    static StringBuilder sb = new StringBuilder();

    static {
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i < 12; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (arr[n] < k) {
            System.out.println(-1);
            return;
        }
        cal(0, n, k);
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }

    static void cal(int sum, int n, int k) {
        if (flag == k) {
            return;
        }
        if (sum == n) {
            flag++;
            if (flag == k) {
                for (int c : dq) {
                    sb.append(c).append('+');
                }
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (sum + i > n) {
                break;
            }
            dq.add(i);
            cal(sum + i, n, k);
            dq.pollLast();
        }
    }
}
