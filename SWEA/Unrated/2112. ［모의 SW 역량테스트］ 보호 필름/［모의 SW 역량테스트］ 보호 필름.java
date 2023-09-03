import java.util.Scanner;

public class Solution {
	static int d;
	static int w;
	static int k;
	static int[][] map;
	static int[][] original;
	static int ans = Integer.MAX_VALUE;
	static int injection = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {

			d = scanner.nextInt();
			w = scanner.nextInt();
			k = scanner.nextInt();

			map = new int[d][w];
			original = new int[d][w];
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = scanner.nextInt();
					original[i][j] = map[i][j];

				}

			}
			fill(0);
			System.out.printf("#%d %d\n",tc,ans);
			ans = Integer.MAX_VALUE;
			

		}

		scanner.close();
	}
	
	static void fill(int depth) {
        if(injection>=ans) return;
		if(isPassed()) {
			ans = Math.min(ans, injection);
			return;
		}
		
		
		if(depth == d) {
			return;
		}
		
		
		
		fill(depth+1);
		
		for (int j = 0; j < w; j++) {
			map[depth][j] = 0;
			
		}
		injection++;
		fill(depth+1);
		injection--;
		
		for (int j = 0; j < w; j++) {
			map[depth][j] = 1;
			
		}
		injection++;
		fill(depth+1);
		
		injection--;		
		
		for (int j = 0; j < w; j++) {
			map[depth][j] = original[depth][j];
			
		}
		
		
		
	}
	

	static boolean isPassed() {
		outer: for (int i = 0; i < w; i++) {
			boolean flag = false;
			for (int j = 0; j <= d - k; j++) {
				int check = 0;
				for (int l = j; l < j + k - 1; l++) {
					if (map[l][i] == map[l + 1][i]) {
						check++;
					}
				}
				if (check == k-1) {
					continue outer;
				}

			}
			if (!flag)
				return false;

		}
		return true;

	}
}
