import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dp = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			sb.append(dp[to] - dp[from - 1]).append("\n");

		}
		
		System.out.println(sb);

		br.close();
	}

}
