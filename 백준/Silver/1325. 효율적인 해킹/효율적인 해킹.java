import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num, child;
		List<Node> descendant;

		public Node(int num) {
			super();
			this.num = num;
			this.descendant = new ArrayList<>();
		}

	}

	static int bfs(Node node) {
		if (memo[node.num] != -1) {
			return memo[node.num];
		}

		int res = 0;
		boolean[] visited = new boolean[n + 1];
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		visited[node.num] = true;
		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (Node child : now.descendant) {
				if (visited[child.num]) {
					continue;
				}
				visited[child.num] = true;
				queue.add(child);
				res++;

			}

		}

		return memo[node.num] = res;

	}

	static int[] memo;
	static Node[] nodes;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		memo = new int[n + 1];
		for (int i = 1; i < memo.length; i++) {
			memo[i] = -1;

		}
		nodes = new Node[n + 1];
		for (int i = 1; i < nodes.length; i++) {
			nodes[i] = new Node(i);

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[b].descendant.add(nodes[a]);

		}
		int max = 0;
		for (int i = 1; i < nodes.length; i++) {
			nodes[i].child = bfs(nodes[i]);
			max = Math.max(nodes[i].child, max);

		}

		for (int i = 1; i < nodes.length; i++) {
			if (nodes[i].child == max) {
				sb.append(i).append(" ");
			}

		}

		System.out.print(sb);

		br.close();
	}

}
