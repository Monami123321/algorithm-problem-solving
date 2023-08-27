import java.util.Scanner;

public class Main { // 백준 10163 색종이
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		int n = scanner.nextInt(); // 색종이 수
		
		int[][] map = new int[1001][1001]; 
		
		for (int i = 0; i < n; i++) {
			int c = scanner.nextInt();
			int r = scanner.nextInt();
			int width = scanner.nextInt();
			int height = scanner.nextInt();
			int paper = i+1; 
			
			for (int j = 0; j < width; j++) {
				for (int k = 0; k < height; k++) {
					map[r+k][c+j] = paper;	
				}
				
			}		
		}
		for (int tc = 0; tc < n; tc++) {
			int cnt = 0;
			
			for (int j = 0; j < 1001; j++) {
				for (int k = 0; k < 1001; k++) {
					if(map[j][k]==tc+1) cnt++;
					
				}
				
			}
			System.out.println(cnt);
					
		}
		
		
		
		scanner.close();
	}

}
