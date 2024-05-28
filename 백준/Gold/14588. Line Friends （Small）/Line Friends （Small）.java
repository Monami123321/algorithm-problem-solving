import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1 << 28;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i][0] = start;
			arr[i][1] = end;
		}
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (isPossible(arr[i], arr[j])) {
					dist[i + 1][j + 1] = dist[j + 1][i + 1] = 1;
				}
			}
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
		StringBuilder sb = new StringBuilder();
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
			if (tmp == INF) {
				tmp = -1;
			}
			sb.append(tmp).append("\n");
		}
		System.out.print(sb);

		br.close();
	}

	static boolean isPossible(int[] a, int[] b) {
		if (a[1] < b[0] || b[1] < a[0]) {
			return false;
		}
		return true;
	}
}
