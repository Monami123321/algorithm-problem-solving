import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BigInteger[] dp = new BigInteger[22];

	static {
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		for (int i = 2; i < 22; i++) {
			dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger n = new BigInteger(br.readLine());
		if (n.equals(BigInteger.valueOf(0))) {
			System.out.println("NO");
			return;
		}
		for (int i = dp.length - 1; i >= 0; i--) {
			if (dp[i].compareTo(n) <= 0) {
				n = n.subtract(dp[i]);
			}
			if (n.equals(BigInteger.valueOf(0))) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");

		br.close();
	}
}
