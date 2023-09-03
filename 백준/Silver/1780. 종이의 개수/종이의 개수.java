import java.util.Scanner;

public class Main {
	static int ansOne = 0;
	static int ansZero = 0;
	static int ansMinus = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = scanner.nextInt();

			}

		}
		divide(map, 0, n, 0, 0);
		System.out.println(ansMinus);
		System.out.println(ansZero);
		System.out.println(ansOne);
		
		

		scanner.close();
	}
	
	static void divide(int[][] arr, int depth, int n, int r, int c) {

		
		int ref = arr[r][c];
		boolean flag = true;
		outer:for (int i = 0; i < n/((int)Math.pow(3, depth)); i++) {
			for (int j = 0; j < n/((int)Math.pow(3, depth)); j++) {
				if(arr[r+i][c+j] != ref) {
					flag = false;
					break outer;
				}
			}

		}
		if(flag) {
			switch (ref) {
			case 1:
				ansOne++;
				return;
			case -1:
				ansMinus++;
				return;
			case 0:
				ansZero++;
				return;
			default:
				break;
			}
			
			
		} else {
			for (int k = 0; k < 3; k++) {
				for (int l = 0; l < 3; l++) {
					divide(arr, depth+1, n, r+n/((int)Math.pow(3, depth+1))*k, c+n/((int)Math.pow(3, depth+1))*l);
					
				}
				
			}
			
			
		}
		
		
		
		
		
		
		
		
	}
}