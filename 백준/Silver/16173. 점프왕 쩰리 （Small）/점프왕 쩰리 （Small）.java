import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 0, 1 };
	static int[] dc = { 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		boolean[][] visited = new boolean[n][n];

		Queue<int[]> queue = new LinkedList<>();
		visited[0][0] = true;
		queue.add(new int[] { 0, 0 });
		String ans = "Hing";

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int r = node[0];
			int c = node[1];

			if (r == n - 1 && c == n - 1) {
				ans = "HaruHaru";
				break;
			}

			for (int i = 0; i < 2; i++) {
				int nr = r + dr[i] * map[r][c];
				int nc = c + dc[i] * map[r][c];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || visited[nr][nc]) {
					continue;
				}

				queue.add(new int[] { nr, nc });
				visited[nr][nc] = true;

			}

		}

		System.out.println(ans);

		br.close();
	}

}
