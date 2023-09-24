import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int[] minEdge = new int[n];
		for (int i = 0; i < n; i++) {
			minEdge[i] = scanner.nextInt();

		}

		int[][] adjMatrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adjMatrix[i][j] = scanner.nextInt();
			}

		}

		int pick = 0;
		int ans = 0;
		boolean[] visited = new boolean[n];
		while (pick < n) {
			int min = Integer.MAX_VALUE;
			int index = -1;

			for (int i = 0; i < n; i++) {
				if(visited[i]) continue;
				if (min > minEdge[i]) {
					min = minEdge[i];
					index = i;
				}

			}
			visited[index] = true;
			ans += minEdge[index];
			pick++;
			
			for (int i = 0; i < n; i++) {
				if (visited[i]||adjMatrix[index][i]==0)
					continue;
				minEdge[i] = Math.min(minEdge[i], adjMatrix[index][i]);
			}

		}
		
		System.out.println(ans);

		scanner.close();
	}

}
