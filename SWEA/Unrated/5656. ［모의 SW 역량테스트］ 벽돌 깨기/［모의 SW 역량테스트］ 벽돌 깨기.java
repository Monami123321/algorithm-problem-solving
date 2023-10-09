import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int[][] initMap;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n, w, h, ans; // 공 쏘는 횟수, 맵 너비, 높이 , 최종 정답
	static Stack<Integer> stack = new Stack<>();

	static void clearMap(int[][] map) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (map[j][i] > 0)
					stack.push(map[j][i]);

			}
			int tmp = h - 1;
			while (!stack.isEmpty()) {
				map[tmp--][i] = stack.pop();
			}
			for (int j = tmp; j >= 0; j--) {
				map[j][i] = 0;

			}

		}

	}

	static void bomb(int startR, int startC, int[][] map) { // 재귀적으로 벽돌 모두 깨버리기
		int range = map[startR][startC];
		map[startR][startC] = 0; // 구슬쏴서 터뜨린 벽돌 -1로 칠하기
		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < range; j++) {
				int nr = startR + dr[i] * j;
				int nc = startC + dc[i] * j;
				if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1 || map[nr][nc] < 1) {
					continue;
				}
				bomb(nr, nc, map);

			}

		}

	}

	static void perm(int w, int n, int r, int[] res) { // 0~w-1 까지 중복허용 n개 뽑기 res에는 몇 번 인덱스에서 구슬 쏠 지 기록
		if (r == n) { // res 구성 끝. 배열 순서대로 구슬 쏘기
			int[][] caseMap = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					caseMap[i][j] = initMap[i][j];
				}

			}

			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < h; j++) {
					if (caseMap[j][res[i]] > 0) {
						bomb(j, res[i], caseMap);
						clearMap(caseMap);
						break;
					}

				}
			} // res 순서대로 구슬 쏘기, 결과는 caseMap에 정리될 것
			int tmp = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (tmp >= ans) {
						return;
					}
					if (caseMap[i][j] > 0)
						tmp++;

				}

			}
			ans = Math.min(ans, tmp);
			return;

		}

		for (int i = 0; i < w; i++) {
			res[r] = i;
			perm(w, n, r + 1, res);

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCases = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCases; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			initMap = new int[h][w]; // 각 테스트케이스마다 처음으로 주어지는 지도
			ans = Integer.MAX_VALUE; // 케이스별 정답

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					initMap[i][j] = Integer.parseInt(st.nextToken());

				}

			} // 맵 입력 끝

			// 시뮬레이션 순서 : wPn 순열을 구성한 뒤 ㅡ> 각 메서드를 만들어서 구슬 쏘기 완전탐색.
			// 필요 메서드 - 1. 중복순열 만들기 2. 구슬 쏘기 3. 벽돌 떨구기(맵 재구성)

			perm(w, n, 0, new int[n]);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

		br.close();
	}

}
