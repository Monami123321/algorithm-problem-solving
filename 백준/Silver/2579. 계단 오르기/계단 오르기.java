
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] stairs = new int[n + 1];
		int[] dp = new int[n + 1]; // n번째 계단까지 진행할 떄 최댓값
		for (int i = 1; i < stairs.length; i++) {
			stairs[i] = scanner.nextInt();

		}
		dp[1] = stairs[1];
		if (n >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}

		if (n >= 3) {
			dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
		}

		for (int i = 4; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);

		}
		System.out.println(dp[n]);
		scanner.close();
	}

}
