import java.util.Scanner;

public class Main {
	static int[] dp = new int[12];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

		}

		for (int tc = 1; tc <= testCases; tc++) {
			int n = scanner.nextInt();
			System.out.println(dp[n]);

		}

		scanner.close();
	}

}
