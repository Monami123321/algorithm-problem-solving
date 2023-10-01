import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();
		for (int tc = 1; tc <= testCases; tc++) {
			int daycharge = scanner.nextInt();
			int monthcharge = scanner.nextInt();
			int quartercharger = scanner.nextInt();
			int ans = scanner.nextInt();

			int[] dp = new int[13];
			int[] plan = new int[13];
			for (int i = 1; i < plan.length; i++) {
				plan[i] = scanner.nextInt();

			}

			for (int i = 1; i < dp.length; i++) {
				if (i < 3) {
					dp[i] = dp[i - 1] + Math.min(daycharge * plan[i], monthcharge);
				} else {
					dp[i] = Math.min(dp[i - 1] + Math.min(daycharge * plan[i], monthcharge),
							dp[i - 3] + quartercharger);
				}

			}
			ans = Math.min(ans, dp[12]);
			System.out.printf("#%d %d\n",tc,ans);

		}

		scanner.close();
	}

}
