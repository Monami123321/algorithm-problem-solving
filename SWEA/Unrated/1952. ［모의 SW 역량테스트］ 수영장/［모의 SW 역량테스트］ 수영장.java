import java.util.Scanner;

public class Solution {
	static int ans;

	static void dfs(int depth, int dayCharge, int monthCharge, int quarterCharge, int[] plan, int sum) {
		if (depth > 11) {
			ans = Math.min(ans, sum);
			return;
		}

		dfs(depth + 1, dayCharge, monthCharge, quarterCharge, plan, sum + dayCharge * plan[depth]);
		dfs(depth + 1, dayCharge, monthCharge, quarterCharge, plan, sum + monthCharge);
		dfs(depth + 3, dayCharge, monthCharge, quarterCharge, plan, sum + quarterCharge);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {
			int dayCharge = scanner.nextInt();
			int monthCharge = scanner.nextInt();
			int quarterCharge = scanner.nextInt();
			ans = scanner.nextInt(); // 1년 이용권

			int[] plan = new int[12];
			for (int i = 0; i < plan.length; i++) {
				plan[i] = scanner.nextInt();

			}
			dfs(0, dayCharge, monthCharge, quarterCharge, plan, 0);
			System.out.printf("#%d %d\n", tc, ans);

		}

		scanner.close();

	}

}
