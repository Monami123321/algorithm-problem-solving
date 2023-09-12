import java.util.Scanner;

public class Solution {
	static int ans;
	static int[] arr;
	
	static void dfs(int depth, int sum, int dayCharge, int monthCharge, int quarterCharge) {
		if(depth>=12) {
			ans = Math.min(ans, sum);
			return;
			
		}
		
		dfs(depth+1, sum+arr[depth]*dayCharge, dayCharge, monthCharge, quarterCharge);
		dfs(depth+1, sum+monthCharge, dayCharge, monthCharge, quarterCharge);
		dfs(depth+3, sum+quarterCharge, dayCharge, monthCharge, quarterCharge);
		
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();
		for (int tc = 1; tc <= testCases; tc++) {
			int dayCharge = scanner.nextInt();
			int monthCharge = scanner.nextInt();
			int quarterCharge = scanner.nextInt();
			//int yearCharge = scanner.nextInt();
			ans = scanner.nextInt();

			arr = new int[12];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextInt();

			}
			
			dfs(0, 0, dayCharge, monthCharge, quarterCharge);
			System.out.printf("#%d %d\n",tc,ans);
			
			
			
		}

		scanner.close();
	}

}
