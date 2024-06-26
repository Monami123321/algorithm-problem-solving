import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[k + 1];
		for (int i = 1; i < k + 1; i++) {
			dp[i] = 1 << 30;
		}
		for (int i = 0; i < n; i++) {
			for (int j = arr[i]; j < k + 1; j++) {
				dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
			}
		}
		if (dp[k] == 1 << 30) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
		br.close();
	}
}
