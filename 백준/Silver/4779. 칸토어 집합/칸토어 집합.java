import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] dp = new char[13][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = new char[]{'-'};
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }
            int n = Integer.parseInt(input);
            if (dp[n] == null) {
                int r = (int) Math.pow(3, n);
                char[] arr = new char[r];
                Arrays.fill(arr, '-');
                getStr(arr, n, 0, r - 1);
            }
            for (int i = 0; i < dp[n].length; i++) {
                sb.append(dp[n][i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void getStr(char[] arr, int n, int left, int right) {
        if (left == right) {
            return;
        }
        int len = (right - left + 1) / 3;
        for (int i = left + len; i <= right - len; i++) {
            arr[i] = ' ';
        }
        getStr(arr, n, left, left + len - 1);
        getStr(arr, n, right - len + 1, right);
        dp[n] = arr;
    }
}
