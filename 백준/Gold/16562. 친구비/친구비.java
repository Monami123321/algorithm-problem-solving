import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent, cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		parent = new int[n + 1];
		cost = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		boolean[] visited = new boolean[n + 1];
		int sum = 0;
		for (int i = 1; i < n+1; i++) {
			int target = findSet(i);
			if (visited[target]) {
				continue;
			}
			visited[target] = true;
			sum += cost[target];
			if (sum > k) {
				System.out.println("Oh no");
				return;
			}
		}
		System.out.println(sum);
		br.close();
	}
	static int findSet(int a) {
		if (parent[a] != a) {
			return parent[a] = findSet(parent[a]);
		}
		return a;
	}

	static void union(int a, int b) {
		int parentA = findSet(a);
		int parentB = findSet(b);
		if (parentA == parentB) {
			return;
		}
		if (parentA > parentB) {
			parent[parentA] = parentB;
			cost[parentB] = Math.min(cost[parentA], cost[parentB]);
		} else {
			parent[parentB] = parentA;
			cost[parentA] = Math.min(cost[parentA], cost[parentB]);
		}
	}
}
