import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] dp;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        dp = new long[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] * i) % MOD;
        }
        System.out.println(dp[n] * recur(dp[n - r], MOD - 2) % MOD * recur(dp[r], MOD - 2) % MOD);
        br.close();
    }

    static long recur(long base, int exp) {
        if (exp == 1) {
            return base;
        }
        long half = recur(base, exp >> 1);
        long res = half * half;
        if ((exp & 1) != 0) {
            res %= MOD;
            res *= base;
        }
        return res % MOD;
    }
}
