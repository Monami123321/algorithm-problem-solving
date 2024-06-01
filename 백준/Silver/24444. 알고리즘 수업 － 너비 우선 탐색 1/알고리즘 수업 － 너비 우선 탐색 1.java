import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 1;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		List<Integer>[] adjList = new ArrayList[n + 1];
		memo = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		for (int i = 1; i < n+1; i++) {
			Collections.sort(adjList[i]);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		memo[start] = cnt++;
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();

			adjList[now].forEach(e-> {
				if (visited[e]) {
					return;
				}
				queue.add(e);
				memo[e] = cnt++;
				visited[e] = true;
			});
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			sb.append(memo[i]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
