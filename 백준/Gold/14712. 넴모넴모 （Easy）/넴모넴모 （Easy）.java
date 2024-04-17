import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		int VAL = (3 << m) + 3;
		int[][] check = new int[n - 1][m - 1];
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				check[i][j] = VAL << (i * m + j);
			}
		}
		
		outer:for (int i = 0; i < 1 << m * n; i++) {
			for (int j = 0; j < n-1; j++) {
				for (int k = 0; k < m - 1; k++) {
					if ((i & check[j][k]) == check[j][k]) {
						continue outer;
					}
				}
			}
			ans++;
		}
		System.out.println(ans);

		br.close();
	}
}
