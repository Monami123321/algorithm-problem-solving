import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1000000;
        char[] arr = br.readLine().toCharArray();
        int[] dp = new int[arr.length + 1];
        if (arr[0] == 48) {
            System.out.println(0);
            return;
        }
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= arr.length; i++) {
            char now = arr[i - 1];
            if (now == 48) {
                if (arr[i - 2] == 48 || arr[i - 2] > 50) {
                    System.out.println(0);
                    return;
                }
                dp[i] = dp[i - 2];
                continue;
            }
            dp[i] = dp[i - 1];
            if (arr[i - 2] == 49 || (arr[i - 2] == 50 && now < 55)) {
                dp[i] += dp[i - 2];
            }
            dp[i] %= MOD;
        }
        System.out.println(dp[arr.length]);
        br.close();
    }
}
