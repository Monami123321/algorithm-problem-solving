
import java.util.Scanner;

public class Solution {

	static int[] parent;
	static int ans;

	static int findSet(int x) {
		if (x != parent[x])
			parent[x] = findSet(parent[x]);
		return parent[x];

	}

	static void union(int x, int y) {
		int xp = findSet(x);
		int yp = findSet(y);
		if (xp < yp)
			parent[yp] = parent[xp];
		else
			parent[xp] = parent[yp];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			parent = new int[n + 1];
			ans = 0;

			for (int i = 1; i < n + 1; i++) {
				parent[i] = i;

			}

			for (int i = 0; i < m; i++) {

				union(scanner.nextInt(), scanner.nextInt());
			}

			int[] check = new int[n + 1];
			for (int i = 1; i < check.length; i++) {
				check[findSet(parent[i])]++;

			}

			for (int i = 1; i < check.length; i++) {

				if (check[i] >= 1)

					ans++;

			}
			System.out.printf("#%d %d\n", tc, ans);

		}

		scanner.close();
	}

}
