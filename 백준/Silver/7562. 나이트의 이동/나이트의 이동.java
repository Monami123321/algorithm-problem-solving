import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());


			boolean[][] visited = new boolean[n][n];
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {startR, startC, 0});
			visited[startR][startC] = true;
			int ans = 0;
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				int r = now[0];
				int c = now[1];
				if (r == endR && c == endC) {
					ans = now[2];
					break;
				}
				for (int i = 0; i < 8; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || visited[nr][nc]) {
						continue;
					}
					queue.add(new int[] {nr, nc, now[2] + 1});
					visited[nr][nc] = true;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
