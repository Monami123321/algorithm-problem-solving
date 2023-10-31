import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Fish {
		int r, c, size, dir;
		boolean isShark, isDead;

		public Fish(int r, int c, int size, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.dir = dir;
		}

		public Fish(int r, int c, int size, int dir, boolean isShark, boolean isDead) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.dir = dir;
			this.isShark = isShark;
			this.isDead = isDead;
		}

	}

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int ans;

	static int[][] copyMap(int[][] map) {
		int[][] res = new int[4][4];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				res[i][j] = map[i][j];
			}

		}
		return res;

	}

	static Fish[] copyArr(Fish[] info) {
		Fish[] res = new Fish[17];
		for (int i = 1; i < res.length; i++) {
			res[i] = new Fish(info[i].r, info[i].c, info[i].size, info[i].dir, info[i].isShark, info[i].isDead);

		}

		return res;
	}

	static void move(int[][] map, Fish[] info) {
		for (int i = 1; i < info.length; i++) {
			if (info[i].isDead || info[i].isShark) {
				continue;
			}
			Fish now = info[i];

			for (int j = 0; j < 8; j++) {
				int nr = now.r + dr[(now.dir + j) % 8];
				int nc = now.c + dc[(now.dir + j) % 8];

				if (nr < 0 || nr > 3 || nc < 0 || nc > 3 || map[nr][nc] == -1) {
					continue;
				}

				swap(map, now.r, now.c, nr, nc);

				if (map[now.r][now.c] == 0) {
					now.r = nr;
					now.c = nc;
					now.dir = (now.dir + j) % 8;
				} else {
					info[map[now.r][now.c]].r = now.r;
					info[map[now.r][now.c]].c = now.c;
					now.r = nr;
					now.c = nc;
					now.dir = (now.dir + j) % 8;
				}

				break;

			}

		}

	}

	static void swap(int[][] map, int fromR, int fromC, int toR, int toC) {
		int tmp = map[fromR][fromC];

		map[fromR][fromC] = map[toR][toC];
		map[toR][toC] = tmp;

	}

	static void dfs(int[][] map, Fish[] info, int cnt, int sharkR, int sharkC) {
		Fish shark = info[map[sharkR][sharkC]];

		shark.isShark = true;
		shark.isDead = true;
		cnt += map[sharkR][sharkC];
		map[sharkR][sharkC] = -1;

		move(map, info);
		map[sharkR][sharkC] = 0;

		int multiple = 1;
		while (multiple < 4) {
			int nr = shark.r + dr[shark.dir] * multiple;
			int nc = shark.c + dc[shark.dir] * multiple;
			if (nr < 0 || nr > 3 || nc < 0 || nc > 3 || map[nr][nc] == 0) {
				multiple++;
				continue;

			}

			int[][] nextMap = copyMap(map);
			Fish[] nextInfo = copyArr(info);

			dfs(nextMap, nextInfo, cnt, nr, nc);
			multiple++;

		}
		ans = Math.max(ans, cnt);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] map = new int[4][4];
		Fish[] info = new Fish[17];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken()); // 물고기 번호(사이즈)
				int b = Integer.parseInt(st.nextToken()) - 1; // 방향
				map[i][j] = a;
				info[a] = new Fish(i, j, a, b);

			}

		}
		ans = 0;
		dfs(map, info, 0, 0, 0);
		System.out.println(ans);

		br.close();
	}

}