import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		int testCases = scanner.nextInt();
		
		for (int tc = 1; tc <= testCases; tc++) {
			
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			String ans = "ON";
			
			for (int i = 0; i < n; i++) {
				if((m & (1<<i)) == 0 ) {
					ans ="OFF";
					break;
				}		
			}
			System.out.printf("#%d %s\n",tc,ans);
				
				
				
		}
		
		
		
		scanner.close();
	}

}
