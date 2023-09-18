import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			int[][] adjArr = new int[n + 1][n + 1];

			for (int i = 0; i < m; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();

				// adjArr[x][y] = adjArr[y][x] = 1;
				adjArr[x][y] = 1; // i j k x y 상대 크기가 정해져있어서 반만 칠해도 됨
			}
			int ans = 0;
			for (int i = 1; i <= n - 2; i++) {
				for (int j = i + 1; j <= n - 1; j++) {
					for (int k = j + 1; k <= n; k++) {
						if (adjArr[i][j] == 1 && adjArr[j][k] == 1 && adjArr[i][k] == 1)
							ans++;

					}

				}

			}

			System.out.printf("#%d %d\n", tc, ans);

		}

		scanner.close();
	}

}
