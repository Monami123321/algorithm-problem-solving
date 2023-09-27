import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


		int[] input = new int[5];
		int max = 0;

		for (int i = 0; i < 5; i++) {
			input[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, input[i]);

		}		
		dp = new long[max+1];
		dp[1] = 1;

		for (int i = 2; i <= max; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];

		}
		for (int i = 0; i < input.length; i++) {
			sb.append(dp[input[i]]).append("\n");

		}
		System.out.print(sb);

		br.close();

	}

}
