import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] ops = new int[4];
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, n - 1, arr[0], arr, ops);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    static void dfs(int depth, int n, int val, int[] arr, int[] ops) {
        if (depth == n) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) {
                continue;
            }
            int tmp = val;
            switch (i) {
                case 0:
                    tmp += arr[depth + 1];
                    break;
                case 1:
                    tmp -= arr[depth + 1];
                    break;
                case 2:
                    tmp *= arr[depth + 1];
                    break;
                case 3:
                    tmp /= arr[depth + 1];
                    break;
                default:
                    break;
            }
            ops[i]--;
            dfs(depth + 1, n, tmp, arr, ops);
            ops[i]++;
        }
    }
}
