import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<int[]>[] adjList = new ArrayList[n];
		boolean[] visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(st.nextToken()) != 0) {
				visited[i] = true;
			}
			adjList[i] = new ArrayList<>();
		}
		visited[n - 1] = false;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new int[] {b, c});
			adjList[b].add(new int[] {a, c});
		}
		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
		pq.add(new long[] {0, 0});
		long ans = -1;
		while (!pq.isEmpty()) {
			long[] now = pq.poll();
			if (visited[(int)now[0]]) {
				continue;
			}
			if (now[0] == n - 1) {
				ans = now[1];
				break;
			}
			visited[(int)now[0]] = true;

			adjList[(int)now[0]].forEach(e -> {
				if (visited[e[0]]) {
					return;
				}
				pq.add(new long[] {e[0], now[1] + e[1]});
			});
		}
		System.out.println(ans);
		br.close();
	}
}
