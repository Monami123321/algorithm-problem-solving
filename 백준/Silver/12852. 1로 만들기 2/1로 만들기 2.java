import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { // 못 풂

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // n>=1
		int[] dp = new int[n + 1];
		int[] trace = new int[n + 1]; // n에서 하는 수행 값
		for (int i = 2; i < trace.length; i++) {
			dp[i] = Integer.MAX_VALUE;

		}

		if (n >= 2) {
			dp[2] = 1;
			trace[2] = 1;
		}
		if (n >= 3) {
			dp[3] = 1;
			trace[3] = 1;
		}

		for (int i = 4; i < dp.length; i++) {
			if (i % 3 == 0) {
				if (dp[i / 3] + 1 < dp[i]) {
					dp[i] = dp[i / 3] + 1;
					trace[i] = i / 3;
				}

			}

			if (i % 2 == 0) {
				if (dp[i / 2] + 1 < dp[i]) {
					dp[i] = dp[i / 2] + 1;
					trace[i] = i / 2;
				}
			}

			if (dp[i - 1] < dp[i]) {
				dp[i] = dp[i - 1] + 1;
				trace[i] = i - 1;
			}

		}

		bw.write(Integer.toString(dp[n]));
		bw.newLine();

		while (n > 0) {
			bw.write(Integer.toString(n));
			bw.write(" ");
			n = trace[n];
		}

		bw.flush();

		br.close();
		bw.close();
	}

}
