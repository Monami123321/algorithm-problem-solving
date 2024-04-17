import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int INF = 1 << 29;
		int testCases = Integer.parseInt(br.readLine());
		tc:
		for (int i = 0; i < testCases; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int[][] dist = new int[n + 1][n + 1];
			for (int j = 1; j < n + 1; j++) {
				Arrays.fill(dist[j], INF);
				dist[j][j] = 0;
			}
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				if (dist[s][e] > t) {
					dist[s][e] = t;
				}
				if (dist[e][s] > t) {
					dist[e][s] = t;
				}
			}
			for (int j = 0; j < w; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = -Integer.parseInt(st.nextToken());
				if (dist[s][e] > t) {
					dist[s][e] = t;
				}

			}

			for (int mid = 1; mid < n + 1; mid++) {
				for (int start = 1; start < n + 1; start++) {
					for (int end = 1; end < n + 1; end++) {
						if (dist[start][end] > dist[start][mid] + dist[mid][end]) {
							dist[start][end] = dist[start][mid] + dist[mid][end];
						}
					}
				}
			}

			// for (int j = 1; j < n + 1; j++) {
			// 	for (int k = 1; k < n + 1; k++) {
			// 		if (dist[j][k] + dist[k][j] < 0) {
			// 			sb.append("YES\n");
			// 			continue tc;
			// 		}
			// 	}
			// }

			for (int j = 1; j < n + 1; j++) {
				if (dist[j][j] < 0) {
					sb.append("YES\n");
					continue tc;
				}
			}
			sb.append("NO\n");
		}
		System.out.print(sb);
		br.close();
	}
}

