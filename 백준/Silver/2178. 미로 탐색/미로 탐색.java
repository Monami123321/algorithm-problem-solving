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
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j) - 48;
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		queue.add(new int[] {0, 0, 1});
		visited[0][0] = true;
		int ans = 1;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[0] == n - 1 && now[1] == m - 1) {
				ans = now[2];
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || visited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}
				queue.add(new int[] {nr, nc, now[2] + 1});
				visited[nr][nc] = true;
			}
		}
		System.out.println(ans);
		br.close();
	}
}
