import java.util.Scanner;

public class Solution {
	static int n;
	static int[] arr;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();
		for (int tc = 1; tc <= testCases; tc++) {
			n = scanner.nextInt();

			arr = new int[n];

			queen(0);
			System.out.printf("#%d %d\n", tc, ans);
			ans = 0;

		}

		scanner.close();
	}

	static boolean checkRow(int depth) {

		for (int i = 0; i <= depth - 1; i++) {
			for (int j = i + 1; j <= depth; j++) {
				if (arr[i] == arr[j])
					return false;
			}

		}
		return true;

	}

	static boolean checkDiagonal(int depth) {
		for (int i = 0; i <= depth - 1; i++) {
			for (int j = i + 1; j <= depth; j++) {
				if (j-i == Math.abs(arr[i]-arr[j]))
					return false;

			}

		}
		return true;

	}

	static void queen(int depth) {
		if (depth == n) { // n-1 인덱스까지 모두 채움 ㅡ> 문제 없이 끝까지 퀸 배치 한 것
			ans++;
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			if (!checkRow(depth))
				continue;
			if (!checkDiagonal(depth))
				continue;
			queen(depth + 1);

		}
		return;

	}
}