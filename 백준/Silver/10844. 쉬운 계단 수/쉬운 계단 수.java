import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[12][n + 1];
		for (int i = 1; i < 10; i++) {
			dp[i + 1][1] = 1;
		}

		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j <= 10; j++) {
				dp[j][i] = (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % MOD;
			}
		}
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += dp[i + 1][n];
			ans %= MOD;
		}
		System.out.println(ans % MOD);
		br.close();
	}
}
