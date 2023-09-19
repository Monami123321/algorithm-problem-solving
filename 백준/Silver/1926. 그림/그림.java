import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int area;
	static int ansArea;
	static int cnt;

	static void dfs(int r, int c) {
		map[r][c] = 0;
		area++;
		
		
		for(int i = 0; i<4 ; i++ ) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr<0 || nr> n-1 || nc<0 || nc> m-1 || map[nr][nc] ==0 ) {
				continue;
			}
			
			dfs(nr, nc);
			
		}
		
		

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = scanner.nextInt();
			}
			
		}
		ansArea =0;
		cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] ==0) continue;
				area =0;
				cnt++;
				dfs(i,j);
				ansArea = Math.max(ansArea, area);
				
			}
			
		}
		
		System.out.println(cnt);
		System.out.println(ansArea);
		
		
		
		
		
		
		
		scanner.close();
	}
}