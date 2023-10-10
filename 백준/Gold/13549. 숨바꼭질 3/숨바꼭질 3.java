import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int range = Math.max(k, n);
		int[] dp = new int[range+1];
		for (int i = n - 1, tmp = 1; i >= 0; i--) {
			dp[i] = tmp++;

		}

		for (int i = n + 1; i <= k; i++) {
			if(i%2 == 0)
				dp[i] = Math.min(dp[i-1]+1, dp[i/2]);
			else {
				dp[i] = Math.min(dp[i-1]+1, dp[(i-1)/2]+1);				
				dp[i] = Math.min(dp[i], dp[(i+1)/2]+1);
			}

			
		}
		
		System.out.println(dp[k]);
		br.close();
	}
}