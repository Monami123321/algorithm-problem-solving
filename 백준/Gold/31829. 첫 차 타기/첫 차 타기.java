import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		List<long[]>[] adjList = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		// 인도
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			long s = Long.parseLong(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			adjList[(int)s].add(new long[] {e, c, 0});
			adjList[(int)e].add(new long[] {s, c, 0});
		}
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			long s = Long.parseLong(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			adjList[(int)s].add(new long[] {e, c, 1});
			adjList[(int)e].add(new long[] {s, c, 1});
		}

		long ans = 0;
		boolean[] visited = new boolean[n + 1];
		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
		pq.add(new long[] {1, 0});
		while (!pq.isEmpty()) {
			long[] now = pq.poll();
			int node = (int)now[0];
			long cost = now[1];
			boolean flag = cost >= k;
			if (visited[node]) {
				continue;
			}
			if (node == n) {
				ans = cost;
				break;
			}
			visited[node] = true;

			adjList[node].forEach(e -> {
				if (visited[(int)e[0]]) {
					return;
				}
				if (flag) {
					pq.add(new long[] {e[0], cost + e[1]});
				} else {
					if (e[2] == 0) {
						pq.add(new long[] {e[0], cost + e[1]});
					} else {
						pq.add(new long[] {e[0], cost + e[1] + k - cost});
					}
				}
			});
		}
		System.out.println(ans);
		br.close();
	}
}
