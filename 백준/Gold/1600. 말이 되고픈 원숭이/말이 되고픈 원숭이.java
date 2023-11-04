import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] jumpDr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] jumpDc = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][] map = new int[h][w];
		int[][][] accMap = new int[k + 1][h][w];
		boolean[][][] visited = new boolean[k + 1][h][w]; // 걸어간거 다시 못가게만 체크

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		for (int i = 0; i < k + 1; i++) {
			for (int j = 0; j < h; j++) {
				for (int j2 = 0; j2 < w; j2++) {
					accMap[i][j][j2] = Integer.MAX_VALUE;
				}

			}
			accMap[i][0][0] = 0;

		}

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			int jump = now[2];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1 || map[nr][nc] == 1 || visited[jump][nr][nc]) {
					continue;
				}
				queue.add(new int[] { nr, nc, jump });
				visited[jump][nr][nc] = true;
				accMap[jump][nr][nc] = Math.min(accMap[jump][nr][nc], accMap[jump][r][c] + 1);

			}

			for (int i = 0; i < 8; i++) {
				if (jump == k) {
					break;
				}
				int nr = r + jumpDr[i];
				int nc = c + jumpDc[i];

				if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1 || map[nr][nc] == 1 || visited[jump + 1][nr][nc]) {
					continue;
				}

				queue.add(new int[] { nr, nc, jump + 1 });
				visited[jump + 1][nr][nc] = true;
				accMap[jump + 1][nr][nc] = Math.min(accMap[jump + 1][nr][nc], accMap[jump][r][c] + 1);

			}

		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < k + 1; i++) {
			ans = Math.min(ans, accMap[i][h - 1][w - 1]);
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

		br.close();
	}

}
