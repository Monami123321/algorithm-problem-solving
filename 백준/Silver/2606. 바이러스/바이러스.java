import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer>[] adjList;
	static int ans;

	static void dfs(int computerNo, boolean[] visited, List<Integer> adjNodes) {
		visited[computerNo] = true;
		for (int i = 0; i < adjNodes.size(); i++) {
			if (visited[adjNodes.get(i)])
				continue;
			dfs(adjNodes.get(i), visited, adjList[adjNodes.get(i)]);

		}
		ans++;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int v = scanner.nextInt();
		int e = scanner.nextInt();

		ans = 0;
		adjList = new ArrayList[v + 1];
		for (int i = 1; i < v + 1; i++) {
			adjList[i] = new ArrayList<>();

		}
		for (int i = 0; i < e; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			adjList[x].add(y);
			adjList[y].add(x);

		}
		dfs(1, new boolean[v+1], adjList[1]);
		System.out.println(ans-1);

		scanner.close();
	}

}
