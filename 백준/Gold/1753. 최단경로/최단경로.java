import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());
		List<int[]>[] adjList = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[s].add(new int[] {e, cost});
		}
		int[] dist = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] {start, 0});
		int pick = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (visited[now[0]]) {
				continue;
			}
			visited[now[0]] = true;
			dist[now[0]] = now[1];
			adjList[now[0]].forEach(e -> {
				if (visited[e[0]]) {
					return;
				}
				pq.add(new int[] {e[0], e[1] + now[1]});
			});
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}
}

