import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반2 {
	static int n;
	static int b;
	static int ans = Integer.MAX_VALUE;
	static int[] heights;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();
		for (int tc = 1; tc <= testCases; tc++) {
			n = scanner.nextInt();
			b = scanner.nextInt();

			heights = new int[n];
			for (int i = 0; i < n; i++) {
				heights[i] = scanner.nextInt();

			}
			
			cal(0, 0);
			System.out.printf("#%d %d\n",tc,ans);
			ans = Integer.MAX_VALUE;
			

		}

		scanner.close();

	}
	static void cal(int depth, int sum) {
		if(sum-b>=ans) {
			return;
		}
		
		if(sum>=b) {
			ans =Math.min(ans, sum-b);
		}
		if(depth==n) {
			return;
		}

		
		
		cal(depth+1, sum+heights[depth]);
		
		cal(depth+1, sum);
		
		
		
	}
}
