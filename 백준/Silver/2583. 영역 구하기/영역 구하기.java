import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
		int q = Integer.parseInt(st.nextToken());
		int[][] map = new int[n + 1][m + 1];
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken()) - 1;

			map[r1][c1]++;
			map[r2 + 1][c1]--;
			map[r1][c2 + 1]--;
			map[r2 + 1][c2 + 1]++;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				map[i][j] += map[i][j - 1];
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[j][i] += map[j - 1][i];
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					pq.add(bfs(map, i, j, n, m));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}
		System.out.print(sb);
		br.close();
	}

	static int bfs(int[][] map, int startR, int startC, int n, int m) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startR, startC});
		map[startR][startC]++;
		int res = 1;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] > 0) {
					continue;
				}
				map[nr][nc]++;
				res++;
				queue.add(new int[] {nr, nc});
			}
		}
		return res;
	}

}