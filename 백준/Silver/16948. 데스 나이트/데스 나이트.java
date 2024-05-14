import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		int endR = Integer.parseInt(st.nextToken());
		int endC = Integer.parseInt(st.nextToken());
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startR, startC, 0});
		boolean[][] visited = new boolean[n][n];
		visited[startR][startC] = true;
		int ans = -1;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			int cost = now[2];
			if (r == endR && c == endC) {
				ans = cost;
				break;
			}
			for (int i = 0; i < 6; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || visited[nr][nc]) {
					continue;
				}
				queue.add(new int[] {nr, nc, cost + 1});
				visited[nr][nc] = true;
			}
		}
		System.out.println(ans);
		br.close();
	}
}
