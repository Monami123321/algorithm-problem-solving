
import java.util.Scanner;

public class Main { // 백준 2536 색종이
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		int n = scanner.nextInt(); // 색종이 수
		int[][] map = new int[100][100];
		

		
		for (int k = 0; k < n; k++) {
			int c = scanner.nextInt();
			int r = scanner.nextInt();
			for (int i = r; i < r+10; i++) {
				for (int j = c; j < c+10; j++) {
					map[i][j]++;
				}
			}
			
		}
		
		int ans = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]>0) ans++;
			}
			
		}
		System.out.println(ans);
		
		

		scanner.close();
	}

}
