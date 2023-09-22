import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;

	static int bfs(int r, int c, int targetR, int targetC) {

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[16][16];
		
		queue.add(new int[] { r, c });
		visited[r][c] = true;

		int res = 0;

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int x = node[0];
			int y = node[1];

			if (x == targetR && y == targetC)
				res = 1;

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (nr < 0 || nr > 15 || nc < 0 || nc > 15 || map[nr][nc] == 1 || visited[nr][nc])
					continue;

				queue.add(new int[] { nr, nc });
				visited[nr][nc]= true; 

			}

		}

		return res;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			map = new int[16][16];
			for (int i = 0; i < 16; i++) {
				st = new StringTokenizer(br.readLine(), "0123", true);
				for (int j = 0; j < 16; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] startPoint = new int[2];
			int[] endPoint = new int[2];

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 2) {
						startPoint[0] = i;
						startPoint[1] = j;

					} else if (map[i][j] == 3) {
						endPoint[0] = i;
						endPoint[1] = j;

					}
				}

			}

			int ans = bfs(startPoint[0], startPoint[1], endPoint[0], endPoint[1]);

			System.out.printf("#%d %d\n", tc, ans);

		}

		br.close();

	}

}
