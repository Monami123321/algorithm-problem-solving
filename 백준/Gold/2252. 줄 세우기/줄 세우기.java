import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = scanner.nextInt();
		int m = scanner.nextInt();

		List<Integer>[] adjList = new ArrayList[n + 1];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		int[] inDegree = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			adjList[a].add(b);
			inDegree[b]++;

		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
				visited[i] = true;
			}

		}
		while (!queue.isEmpty()) {
			int node = queue.poll();

			sb.append(node).append(" ");

			for (int i = 0; i < adjList[node].size(); i++) {
				if (!visited[adjList[node].get(i)]) {
					inDegree[adjList[node].get(i)]--;
					if (inDegree[adjList[node].get(i)] == 0) {
						visited[adjList[node].get(i)] = true;
						queue.add(adjList[node].get(i));
					}
				}

			}

		}

		System.out.println(sb);

		scanner.close();
	}

}
