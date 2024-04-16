import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r, c, weight, speed, dir;

		public Node(int r, int c, int weight, int speed, int dir) {
			this.r = r;
			this.c = c;
			this.weight = weight;
			this.speed = speed;
			this.dir = dir;
		}
	}

	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N, M, K;
	static int[][][] map;
	static List<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 맵 크기
		M = Integer.parseInt(st.nextToken()); // 파이어볼 수
		K = Integer.parseInt(st.nextToken()); // 명령수
		map = new int[N][N][4]; // {갯수, 질량, 속력, 방향} 방향 -> -1 다른거나옴 1 홀수 계속같음 2 짝수 계속같음
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new Node(r, c, w, s, d));
		}
		for (int i = 0; i < K; i++) {
			move();
			nextList();
			clearMap();
		}
		System.out.println(list.stream().map(e -> e.weight).reduce(0, (prev, now) -> prev + now));
		br.close();
	}

	static void move() {
		list.forEach(e -> {
			int nr = e.r + dr[e.dir] * e.speed;
			int nc = e.c + dc[e.dir] * e.speed;
			nr = adjustPos(nr);
			nc = adjustPos(nc);
			map[nr][nc][0]++;
			map[nr][nc][1] += e.weight;
			map[nr][nc][2] += e.speed;
			int prevDir = map[nr][nc][3];
			if (prevDir == -1) {
				return;
			}
			if (map[nr][nc][0] > 1) {
				prevDir = (prevDir & 1) == 0 ? 2 : 1;
			}
			int dir = e.dir & 1;
			if (prevDir == 0) {
				map[nr][nc][3] = e.dir;
			} else if (prevDir == 1) {
				if (dir == 0) {
					map[nr][nc][3] = -1;
				}
			} else {
				if (dir == 1) {
					map[nr][nc][3] = -1;
				}
			}
		});
	}

	static int adjustPos(int a) {
		if (a >= 0) {
			return a % N;
		}
		a += (-a / N) * N;
		if (a < 0) {
			a += N;
		}
		return a;
	}

	static void clearMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					map[i][j][k] = 0;
				}
			}
		}
	}

	static void nextList() {
		List<Node> nextList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j][0] == 1) {
					nextList.add(new Node(i, j, map[i][j][1], map[i][j][2], map[i][j][3]));
				} else if (map[i][j][0] > 1) {
					int w = map[i][j][1] / 5;
					if (w == 0) {
						continue;
					}
					int s = map[i][j][2] / map[i][j][0];
					int d = map[i][j][3] == -1 ? 1 : 0;
					for (int k = 0; k <= 6; k += 2) {
						nextList.add(new Node(i, j, w, s, k + d));
					}
				}
			}
		}
		list = nextList;
	}
}
