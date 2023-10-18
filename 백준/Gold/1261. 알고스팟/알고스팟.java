import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, - 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // 가로
		int n = Integer.parseInt(st.nextToken()); // 세로

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), "01", true);
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		int[][] accMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				accMap[i][j] = Integer.MAX_VALUE;
			}

		}
		accMap[0][0] = 0;

		Queue<int[]> queue = new LinkedList<>(); // r,c,weight 순
		queue.add(new int[] { 0, 0, 0 });

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int r = node[0];
			int c = node[1];
			int weight = node[2];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || weight + map[nr][nc] >= accMap[nr][nc]) {
					continue;
				}

				accMap[nr][nc] = weight + map[nr][nc];
				queue.add(new int[] { nr, nc, accMap[nr][nc] });

			}
		}
		
		System.out.println(accMap[n-1][m-1]);

		br.close();
	}

}
