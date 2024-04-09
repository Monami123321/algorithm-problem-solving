import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1}; // 0 가짜 2 4 6 8 대각선
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 맵크기
		int m = Integer.parseInt(st.nextToken()); // 이동정보갯수
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<int[]> cloud = new ArrayList<>();
		cloud.add(new int[] {n - 1, 0});
		cloud.add(new int[] {n - 1, 1});
		cloud.add(new int[] {n - 2, 0});
		cloud.add(new int[] {n - 2, 1});

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int multiple = Integer.parseInt(st.nextToken());

			// 이번 이동에서 구름 생긴곳 검사
			boolean[][] visited = new boolean[n][n];
			// 구름이동
			cloud.forEach(e -> {
				e[0] += dr[dir] * multiple;
				if (e[0] < 0) {
					while (e[0] < 0) {
						e[0] += n;
					}
				} else {
					e[0] %= n;
				}
				e[1] += dc[dir] * multiple;
				if (e[1] < 0) {
					while (e[1] < 0) {
						e[1] += n;
					}
				} else {
					e[1] %= n;
				}
				++map[e[0]][e[1]];
				visited[e[0]][e[1]] = true;
			});

			// 대각선 검사, 바구니 수 만큼 늘리기
			cloud.forEach(e -> {
				int cnt = 0;
				for (int j = 2; j <= 8; j += 2) {
					int nr = e[0] + dr[j];
					int nc = e[1] + dc[j];
					if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || map[nr][nc] == 0) {
						continue;
					}
					++cnt;
				}
				map[e[0]][e[1]] += cnt;
			});
			// 이번 구름 없애기
			cloud.clear();

			// 새 구름 만들기
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (map[j][k] >= 2 && !visited[j][k]) {
						cloud.add(new int[] {j, k});
						map[j][k] -= 2;
					}
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans);
		br.close();
	}
}
