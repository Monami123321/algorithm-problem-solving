import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r, c, id, dir;

		public Node(int r, int c, int id) {
			this.r = r;
			this.c = c;
			this.id = id;
		}
	}

	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<Node> list;
	static List<int[]> walls;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		walls = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					if (map[i][j] < 6) {
						list.add(new Node(i, j, map[i][j]));
					} else {
						walls.add(new int[] {i, j});
					}
				}
			}
		}
		combination(0,list.size());
		System.out.println(ans);
		br.close();
	}

	static void combination(int depth, int n) {
		// cctv 사이즈 만큼 각각 방향이 0 1 2 3 모든 조합
		if (depth == n) {
			// 검증 시작
			int[][] caseMap = new int[N][M];
			walls.forEach(e -> {
				caseMap[e[0]][e[1]] = 6;
			});
			list.forEach(e -> {
				doCheck(caseMap,e);
			});
			ans = Math.min(ans, count(caseMap));
			return;
		}

		for (int i = 0; i < 4; i++) {
			list.get(depth).dir = i;
			combination(depth + 1, n);
		}
	}

	static void doCheck(int[][] caseMap, Node node) {
		int r = node.r;
		int c = node.c;
		if (node.id == 1) {
			fill(caseMap, r, c, node.dir);
		} else if (node.id == 2) {
			fill(caseMap, r, c, node.dir);
			fill(caseMap, r, c, (node.dir + 2) % 4);
		} else if (node.id == 3) {
			fill(caseMap, r, c, node.dir);
			fill(caseMap, r, c, (node.dir + 1) % 4);

		} else if (node.id == 4) {
			fill(caseMap, r, c, node.dir);
			fill(caseMap, r, c, (node.dir + 1) % 4);
			fill(caseMap, r, c, (node.dir + 2) % 4);

		} else {
			fill(caseMap, r, c, node.dir);
			fill(caseMap, r, c, (node.dir + 1) % 4);
			fill(caseMap, r, c, (node.dir + 2) % 4);
			fill(caseMap, r, c, (node.dir + 3) % 4);

		}

	}

	static void fill(int[][] caseMap, int r, int c, int dir) {
		while (r >= 0 && r <= N - 1 && c >= 0 && c <= M - 1) {
			if (map[r][c] == 6) {
				return;
			}
			caseMap[r][c] = -1;
			r += dr[dir];
			c += dc[dir];
		}
	}

	static int count(int[][] caseMap) {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (caseMap[i][j] == 0) {
					res++;
				}
			}
		}
		return res;
	}
}
