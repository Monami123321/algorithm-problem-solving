import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 1 || n == 3) {
			System.out.println(-1);
			return;
		}
		int[] dp = new int[10];
		dp[5] = 1;
		dp[6] = 3;
		dp[7] = 2;
		dp[8] = 4;
		dp[9] = 3;

		int ans = n / 5 - 1;
		ans += dp[n % 5 + 5];
		System.out.println(ans);

		br.close();
	}
}