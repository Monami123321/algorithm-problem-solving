import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCases = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCases; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), "0123456789", true);
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			int[][] acc = new int[n][n];
			for (int i = 0; i < acc.length; i++) {
				for (int j = 0; j < acc.length; j++) {
					acc[i][j] = Integer.MAX_VALUE;

				}

			}
			acc[0][0] = 0;

			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { 0, 0 });

			while (!queue.isEmpty()) {
				int[] node = queue.poll();
				int r = node[0];
				int c = node[1];

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || acc[r][c] + map[nr][nc] >= acc[nr][nc]) {
						continue;
					}
					
					acc[nr][nc] = acc[r][c]+map[nr][nc]; 
					queue.add(new int[] {nr,nc});

				}

			}
			
			System.out.printf("#%d %d\n",tc,acc[n-1][n-1]);

		}

		br.close();
	}

}
