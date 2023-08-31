import java.util.Scanner;

public class Solution {
	static int power(int n, int m) {
		if (m == 1) {
			return n;
		}
		int half = power(n, m / 2);
		if (m % 2 == 0) {
			return half * half;

		} else
			return half * half * n;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = 10;

		for (int tc = 1; tc <= testCases; tc++) {
			scanner.nextInt();
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			System.out.printf("#%d %d\n", tc, power(n, m));
		}
		scanner.close();
	}
}