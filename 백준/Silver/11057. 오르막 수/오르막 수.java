import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 10_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[10][n + 1];
		for (int i = 0; i < 10; i++) {
			arr[i][1] = 1;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 2; j < n + 1; j++) {
				for (int k = 0; k <= i; k++) {
					arr[i][j] += arr[k][j - 1] % MOD;
				}
				arr[i][j] %= MOD;
			}
		}
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += arr[i][n];
		}
		System.out.println(ans % MOD);

		br.close();
	}
}
