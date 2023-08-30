import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;
	static int choosed =0;
	static List<boolean[]> comb = new ArrayList<>() ;
	
	
	
	static void synergy(boolean[] arr) { // 입력된 배열에서 2개를 골라 시너지 계산 후 리턴
		int[] chosen = new int[n/2];
		int[] unchosen = new int[n/2];
		for (int i = 0,cIndex=0,uIndex=0; i < n; i++) {
			if(arr[i]) chosen[cIndex++] = i;
			else unchosen[uIndex++] = i;		
		}
		int sumChosen = 0;
		int sumUnchosen = 0;

		for (int i = 0; i < n/2-1; i++) {
			for (int j = i+1; j <= n/2-1; j++) {
				
				sumChosen += map[chosen[i]][chosen[j]] + map[chosen[j]][chosen[i]];	
			}
			
		}
		for (int i = 0; i < n/2-1; i++) {
			for (int j = i+1; j <= n/2-1; j++) {
				sumUnchosen += map[unchosen[i]][unchosen[j]] + map[unchosen[j]][unchosen[i]];	
			}
			
		}
		min = Math.min(min, Math.abs(sumChosen-sumUnchosen));
		return;

		
		
		
		
	}
	
	static void combination(int visitedIndex) {
		if(visitedIndex == visited.length) {
			if (choosed!=n/2) {
				choosed--;
				return;
			}
			choosed--;
			boolean[] result = new boolean[n];
			for (int i = 0 ; i < n; i++) {
				if(visited[i]) {
					result[i] = true;
				}
			}
			comb.add(result);
			return;
		}
		
		

		visited[visitedIndex] = true;
		choosed++;
		combination(visitedIndex+1);
		
		visited[visitedIndex] = false;
		combination(visitedIndex+1);
		
		return;
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int testCases = scanner.nextInt();
		for (int tc = 1; tc <= testCases; tc++) {
			n = scanner.nextInt();
			map = new int[n][n];
			visited = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = scanner.nextInt();	
				}
			}
			combination(0);
			for (int i = 0; i < comb.size(); i++) {
				synergy(comb.get(i));			
			}
			System.out.printf("#%d %d\n",tc,min);
			
			comb.clear();
			choosed =0;
			min = Integer.MAX_VALUE;
			
			
			
		}
		
		
		
		
		
		scanner.close();
	}
}