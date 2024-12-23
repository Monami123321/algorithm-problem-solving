import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 2];
        dp[0] = dp[1] = 1;
        long leaf = 4;
        for (int i = 2; i <= n; i++) {
            dp[i] = leaf - dp[i - 1];
            leaf <<= 1;
        }
        System.out.println(dp[n]);
        br.close();
    }
}
