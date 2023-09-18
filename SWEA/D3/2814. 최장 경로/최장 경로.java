import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class Node {
		int id;
		List<Node> adjNodes;

		public Node(int id) {
			super();
			this.id = id;
			this.adjNodes = new ArrayList<>();
		}

	}

	static int ans;

	static void dfs(int depth, Node node, boolean[] visited) {
		visited[node.id] = true;

		for (int i = 0; i < node.adjNodes.size(); i++) {
			if (visited[node.adjNodes.get(i).id]) {
				continue;
			}
			//visited[node.adjNodes.get(i).id] = true;
			dfs(depth + 1, node.adjNodes.get(i), visited);
			//visited[node.adjNodes.get(i).id] = false;
		}

		ans = Math.max(ans, depth);
		visited[node.id] = false;
		return;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();
		for (int tc = 1; tc <= testCases; tc++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			Node[] graph = new Node[n+1];
			for (int i = 1; i < n+1; i++) {
				graph[i] = new Node(i);

			}

			for (int i = 0; i < m; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				
				//if(graph[x].adjNodes.contains(graph[y])) continue;
				graph[x].adjNodes.add(graph[y]);
				graph[y].adjNodes.add(graph[x]);

			}
			ans = 0;

			for (int i = 1; i < n+1; i++) {
				dfs(1, graph[i], new boolean[n+1]);

			}
			System.out.printf("#%d %d\n", tc, ans);

		}

		scanner.close();
	}

}
