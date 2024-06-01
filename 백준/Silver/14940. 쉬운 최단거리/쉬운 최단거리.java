import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] res = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					queue.add(new int[] {i, j, 0});
					map[i][j] = -1;
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			int t = now[2];
			res[r][c] = t;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] <= 0) {
					continue;
				}
				queue.add(new int[] {nr, nc, t + 1});
				map[nr][nc] = -1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					sb.append(0).append(" ");
				} else if (map[i][j] == 1) {
					sb.append(-1).append(" ");
				} else {
					sb.append(res[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
