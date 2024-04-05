import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < (1 << n); i++) {
			if (Integer.bitCount(i) != n / 2) {
				continue;
			}
			int[] team1 = new int[n >> 1];
			int[] team2 = new int[n >> 1];
			int t1Index = 0;
			int t2Index = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					team1[t1Index++] = j;
				} else {
					team2[t2Index++] = j;
				}
			}
			int t1Sum = 0;
			int t2Sum = 0;

			for (int j = 0; j < (n >> 1) - 1; j++) {
				for (int k = j + 1; k < (n >> 1); k++) {
					t1Sum += arr[team1[j]][team1[k]] + arr[team1[k]][team1[j]];
					t2Sum += arr[team2[j]][team2[k]] + arr[team2[k]][team2[j]];
				}
			}
			ans = Math.min(ans, Math.abs(t1Sum - t2Sum));
		}
		System.out.println(ans);
		br.close();
	}
}
