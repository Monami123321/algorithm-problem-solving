import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int START_R = 7;
		final int START_C = 0;
		final int END_R = 0;
		final int END_C = 7;
		char[][] map = new char[8][8];
		List<int[]> walls = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == '#') {
					walls.add(new int[] {i, j});
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		int time = 0;
		queue.add(new int[] {START_R, START_C, time});
		while (!queue.isEmpty()) {
			while (!queue.isEmpty() && queue.peek()[2] == time) {
				int[] now = queue.poll();
				int r = now[0];
				int c = now[1];
				int t = now[2];
				if ((r == END_R && c == END_C) || walls.isEmpty()) {
					System.out.println(1);
					return;
				}

				for (int i = 0; i < 8; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr > 7 || nc < 0 || nc > 7 || map[nr][nc] == '#') {
						continue;
					}
					if (nr - 1 >= 0 && map[nr - 1][nc] == '#') {
						continue;
					}
					queue.add(new int[] {nr, nc, t + 1});
				}

				if (r - 1 >= 0 && map[r - 1][c] == '.') {
					queue.add(new int[] {r, c, t + 1});
				}

			}
			walls.forEach(e -> {
				map[e[0]][e[1]] = '.';
				e[0]++;
			});
			int size = walls.size();
			for (int i = 0; i < size; i++) {
				int[] tmp = walls.get(i);
				if (tmp[0] == 8) {
					walls.remove(i--);
					size--;
				} else {
					map[tmp[0]][tmp[1]] = '#';
				}
			}
			time++;
		}
		System.out.println(0);
		br.close();
	}
}
