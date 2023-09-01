import java.util.Scanner;

public class Solution {
	static int ans = Integer.MAX_VALUE;
	static int n;
	static int b;
	static boolean[] visited;
	static int[] heights;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {
			n = scanner.nextInt();
			b = scanner.nextInt();
			heights = new int[n];
			visited = new boolean[n];

			for (int i = 0; i < heights.length; i++) {
				heights[i] = scanner.nextInt();

			}
			powerset(0);
			System.out.printf("#%d %d\n", tc, ans);

			ans = Integer.MAX_VALUE;

		}

		scanner.close();

	}

	static void powerset(int depth) {
		if (depth == n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					sum += heights[i];
				}
				if (sum >= b) {
					ans = Math.min(ans, sum - b);

				}

			}
			return;
		}

		visited[depth] = true;
		powerset(depth + 1);

		visited[depth] = false;
		powerset(depth + 1);

		return;
	}

}
