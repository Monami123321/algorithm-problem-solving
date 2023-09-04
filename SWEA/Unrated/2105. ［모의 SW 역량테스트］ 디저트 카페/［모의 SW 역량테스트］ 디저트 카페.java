import java.util.Scanner;

public class Solution {
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	static int[][] map;
	static int n;
	static int ans;
	
	
	
	static void tour(int startR, int startC, int r, int c, int dir, boolean[] visited) {
		if(startR==r && startC ==c && dir ==3) {
			int sum = 0;
			for (int i = 1; i < visited.length; i++) {
				if(visited[i]) sum++;
			}
			ans = Math.max(ans, sum);
			return;
		}
		if(visited[map[r][c]]) {
			return;
		}
		if(dir>3) {
			return;
		}
		

		
		if(r+dr[dir]>=0&&r+dr[dir]<=n-1&&c+dc[dir]>=0&&c+dc[dir]<=n-1) {
			visited[map[r][c]] = true;
			tour(startR, startC, r+dr[dir], c+dc[dir], dir, visited);
			visited[map[r][c]] = false;
		}
		
		if(dir<3 && r+dr[dir+1]>=0&&r+dr[dir+1]<=n-1&&c+dc[dir+1]>=0&&c+dc[dir+1]<=n-1) {
			visited[map[r][c]] = true;
			tour(startR, startC, r+dr[dir+1], c+dc[dir+1], dir+1, visited);
			visited[map[r][c]] = false;
		}
		
		return;	
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int testCases = scanner.nextInt();
		
		for(int tc = 1; tc<=testCases;tc++) {
			n = scanner.nextInt();
			map = new int[n][n];
			ans = -1;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] =scanner.nextInt();
					
				}
				
			}
			
			for (int i = 0; i < n-2; i++) {
				for (int j = 1; j < n-1; j++) {
					tour(i, j, i, j, 0, new boolean[101]);
					
				}
				
			}
			
			System.out.printf("#%d %d\n",tc,ans);
			
			
			
			
		}
		
		
		
		
		scanner.close();
		
	}

}
