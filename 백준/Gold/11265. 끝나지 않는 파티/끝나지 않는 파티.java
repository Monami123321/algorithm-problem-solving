import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int m = 1; m < n + 1; m++) {
			for (int s = 1; s < n + 1; s++) {
				for (int e = 1; e < n + 1; e++) {
					if (dist[s][e] > dist[s][m] + dist[m][e]) {
						dist[s][e] = dist[s][m] + dist[m][e];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (dist[a][b] <= c) {
				sb.append("Enjoy other party\n");
			} else {
				sb.append("Stay here\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
