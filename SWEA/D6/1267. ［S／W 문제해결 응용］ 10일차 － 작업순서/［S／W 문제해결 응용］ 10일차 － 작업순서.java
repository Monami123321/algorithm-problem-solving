import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int v = scanner.nextInt();
			int e = scanner.nextInt();

			int[][] adjMatrix = new int[v + 1][v + 1];
			int[] inDegree = new int[v + 1];
			boolean[] visited = new boolean[v + 1];

			for (int i = 0; i < e; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();

				adjMatrix[a][b] = 1;
				inDegree[b]++;

			}

			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i < inDegree.length; i++) {
				if (inDegree[i] == 0) {
					visited[i] = true;
					queue.add(i);
				}
			}

			System.out.printf("#%d ", tc);

			while (!queue.isEmpty()) {
				int node = queue.poll();

				System.out.printf("%d ", node);
				for (int i = 1; i < v + 1; i++) {
					if (adjMatrix[node][i] == 1) {
						inDegree[i]--;
					}

				}

				for (int i = 1; i < inDegree.length; i++) {
					if (inDegree[i] == 0 && !visited[i]) {
						queue.add(i);
						visited[i] = true;
					}

				}

			}

			System.out.println();

		}

		scanner.close();
	}

}
