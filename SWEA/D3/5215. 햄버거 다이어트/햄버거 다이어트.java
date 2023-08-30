import java.util.Scanner;

public class Solution {
	static int[] scores;
	static int[] calories;
	static boolean[] visited;
	static int sumScores =0;
	static int sumCalories =0;
	static int max=0;
	static int limit;
	
	
	static void powerset(int index) {
		if(index == visited.length) {
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					sumCalories += calories[i];
					sumScores += scores[i];
				}	
			}
			if (sumCalories <= limit ) {
				max = Math.max(max, sumScores);
			}
			sumCalories = 0;
			sumScores = 0;	
			return;
		}
		
		visited[index] = true;
		powerset(index+1);
		
		visited[index] = false;
		powerset(index+1);
		
		return;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		for (int tc = 1; tc <= testCases; tc++) {
			int n = sc.nextInt();
			limit = sc.nextInt();
			
			scores = new int[n];
			calories = new int[n];
			visited = new boolean[n];
			
			
			for (int i = 0; i < n; i++) {
				scores[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			
			powerset(0);
			
			System.out.printf("#%d %d\n",tc,max);
			max = 0;

			
		}
		
		
		
		sc.close();
	}
}