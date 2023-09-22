import java.util.Scanner;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] ans;
	static boolean[][] visited;
	static int l;
	static int n;
	static int m;

	static void dfs(int r, int c, int depth) {
		visited[r][c] = true;
		ans[r][c] = true;
		if(depth==l) {
			visited[r][c] = false;
			return;
		}

		switch (map[r][c]) {
		case 1:
			for (int i = 0; i < 4; i++) { //상하좌우
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 ||map[nr][nc] == 0 || visited[nr][nc] )
					continue;
				
				int next = map[nr][nc];
				if(i == 0) {
					if(next == 3||next == 4||next == 7)
						continue;
				}
				if(i == 1) {
					if(next == 3||next == 5||next == 6)
						continue;
				}
				if(i == 2) {
					if(next == 2||next == 6||next == 7)
						continue;
				}
				if(i == 3) {
					if(next == 2||next == 4||next == 5)
						continue;
				}
				dfs(nr, nc, depth+1);

			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) { //상하만
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] == 0||visited[nr][nc])
					continue;
				int next = map[nr][nc];
				
				if(i == 0) {
					if(next == 3||next == 4||next == 7)
						continue;
				}
				if(i == 1) {
					if(next == 3||next == 5||next == 6)
						continue;
				}
				dfs(nr, nc, depth+1);	

			}
			break;
		case 3:
			for (int i = 2; i < 4; i++) { //좌우만
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] == 0||visited[nr][nc])
					continue;
				int next = map[nr][nc];
				
				if(i == 2) {
					if(next == 2||next == 6||next == 7)
						continue;
				}
				if(i == 3) {
					if(next == 2||next == 4||next == 5)
						continue;
				}
				dfs(nr, nc, depth+1);	

			}
			break;
		case 4:
			for (int i = 0; i < 4; i+=3) { //상우만
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] == 0||visited[nr][nc])
					continue;
				int next = map[nr][nc];
				
				if(i == 0) {
					if(next == 3||next == 4||next == 7)
						continue;
				}
				if(i == 3) {
					if(next == 2||next == 4||next == 5)
						continue;
				}
				dfs(nr, nc, depth+1);	

			}
			break;
		case 5:
			for (int i = 1; i < 4; i+=2) { //하우만
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] == 0||visited[nr][nc])
					continue;
				int next = map[nr][nc];
				
				if(i == 1) {
					if(next == 3||next == 5||next == 6)
						continue;
				}
				if(i == 3) {
					if(next == 2||next == 4||next == 5)
						continue;
				}
				dfs(nr, nc, depth+1);	

			}
			break;
		case 6:
			for (int i = 1; i < 3; i++) { //하좌만
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] == 0||visited[nr][nc])
					continue;
				int next = map[nr][nc];
				
				if(i == 1) {
					if(next == 3||next == 5||next == 6)
						continue;
				}
				if(i == 2) {
					if(next == 2||next == 6||next == 7)
						continue;
				}
				dfs(nr, nc, depth+1);	

			}
			break;
		case 7:
			for (int i = 0; i < 4; i+=2) { //상좌만
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] == 0||visited[nr][nc])
					continue;
				int next = map[nr][nc];
				
				if(i == 0) {
					if(next == 3||next == 4||next == 7)
						continue;
				}
				if(i == 2) {
					if(next == 2||next == 6||next == 7)
						continue;
				}
				dfs(nr, nc, depth+1);	

			}
			break;

		default:
			break;
		}
		
		visited[r][c] = false;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			l = scanner.nextInt();

			map = new int[n][m];
			ans = new boolean[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = scanner.nextInt();

				}

			}
			dfs(r, c, 1);
			
			int ansNum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(ans[i][j])
						ansNum++;
					
				}
				
			}
			
			System.out.printf("#%d %d\n",tc,ansNum);
			

		}

		scanner.close();

	}

}
