import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	static class Virus {
		int r, c, size, dir;

		public Virus(int r, int c, int size, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.dir = dir;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCases = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCases; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 한 변의 길이
			int m = Integer.parseInt(st.nextToken()); // 격리시간
			int k = Integer.parseInt(st.nextToken()); // 군집의 갯수

			List<Virus> list = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				list.add(new Virus(r, c, size, dir));

			}

			while (m > 0) {
				m--;

				int[][] visited = new int[n][n]; // 미생물 겹치는지 체크

				for (int i = 0; i < list.size(); i++) {
					Virus virus = list.get(i);
					virus.c += dc[virus.dir];
					virus.r += dr[virus.dir];
					visited[virus.r][virus.c]++;
					if (virus.r == 0 || virus.r == n - 1 || virus.c == 0 || virus.c == n - 1) {
						if (virus.dir == 1) {
							virus.dir = 0;
						} else if (virus.dir == 0) {
							virus.dir = 1;
						} else if (virus.dir == 2) {
							virus.dir = 3;
						} else {
							virus.dir = 2;
						} // 방향 바꾸고

						virus.size /= 2; // 사이즈 반으로 줄이기

					}
				}

				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						if (visited[x][y] > 1) {
							int cnt = 0;
							int tmpDir = -1;
							int tmpMax = -1;
							int loopSize = list.size();
							for (int l = 0; l < loopSize; l++) {
								Virus chk = list.get(l);
								if (chk.r == x && chk.c == y) {
									cnt += chk.size;
									if (tmpMax < chk.size) {
										tmpMax = chk.size;
										tmpDir = chk.dir;
									}
									list.remove(chk); // 필요한 정보 다 뽑고 제거
									loopSize--;
									l--;
								}
							}
							list.add(new Virus(x, y, cnt, tmpDir)); // 합쳐진 정보로 다시 바이러스 생성
						}

					}

				}

			} // m 시간 지남

			int ans = 0;
			for (Virus v : list) {
				ans += v.size;

			}

			System.out.printf("#%d %d\n", tc, ans);

		}

		br.close();
	}

}
