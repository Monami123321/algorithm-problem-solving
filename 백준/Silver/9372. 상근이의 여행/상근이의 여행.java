

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int testCases = scanner.nextInt();
		for(int tc = 1; tc<=testCases; tc++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			scanner.nextLine();
			
			for (int i = 0; i < m; i++) {
				scanner.nextLine();
				
			}
			System.out.println(n-1);
			
			
			
		}
		
		
		
		scanner.close();
	}

}
