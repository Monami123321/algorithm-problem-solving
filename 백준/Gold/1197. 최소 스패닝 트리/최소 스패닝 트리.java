import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge> {
		int a, b;
		long w;

		public Edge(int a, int b, long w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {

			return Long.compare(this.w, o.w);
		}

	}

	static int V, E;
	static int[] parent;

	static int findset(int x) {
		if (x != parent[x]) {
			parent[x] = findset(parent[x]);

		}
		return parent[x];

	}

	static void union(int x, int y) {
		parent[findset(y)] = findset(x);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		V = scanner.nextInt();
		E = scanner.nextInt();

		Edge[] edges = new Edge[E];
		parent = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			parent[i] = i;

		}

		for (int i = 0; i < E; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			long c = scanner.nextInt();

			edges[i] = new Edge(a, b, c);

		}

		Arrays.sort(edges);
		int pick = 0;
		long ans = 0L;
		for (int i = 0; i < E; i++) {
			Edge edge = edges[i];

			if (findset(edges[i].a) == findset(edges[i].b)) {
				continue;
			}

			pick++;
			ans += edge.w;
			union(edge.a, edge.b);
			if (pick == V - 1) {
				break;
			}

		}
		System.out.println(ans);

		scanner.close();
	}

}
