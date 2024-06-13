import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[6];
            for (int i = 0; i < 6; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getDate(arr, n)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static int getDate(int[] arr, int limit) {
        long sum = getSum(arr);
        int res = 1;
        int[] tmp = new int[6];
        while (sum <= limit) {
            ++res;
            for (int i = 0; i < 6; i++) {
                int now = arr[i];
                now += arr[(i + 1) % 6];
                now += arr[(i + 5) % 6];
                now += arr[(i + 3) % 6];
                tmp[i] = now;
            }
            sum = getSum(tmp);
            System.arraycopy(tmp, 0, arr, 0, 6);
        }
        return res;
    }

    static long getSum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
