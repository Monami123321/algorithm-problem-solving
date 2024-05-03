import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int INF = 1 << 29;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(dist[i], INF);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], cost);
		}
		for (int mid = 1; mid < n + 1; mid++) {
			for (int s = 1; s < n + 1; s++) {
				for (int e = 1; e < n + 1; e++) {
					if (dist[s][e] > dist[s][mid] + dist[mid][e]) {
						dist[s][e] = dist[s][mid] + dist[mid][e];
					}
				}
			}
		}
		int ans = INF;
		for (int i = 1; i < n + 1; i++) {
			ans = Math.min(ans, dist[i][i]);
		}
		if (ans == INF) {
			ans = -1;
		}
		System.out.println(ans);
		br.close();
	}
}
