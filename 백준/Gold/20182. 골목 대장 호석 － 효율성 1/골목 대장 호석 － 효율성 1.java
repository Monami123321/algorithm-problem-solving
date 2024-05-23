import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, start, end, limit;
	static List<int[]>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		int min = 1;
		int max = 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			max = Math.max(max, c);
			adjList[a].add(new int[] {b, c});
			adjList[b].add(new int[] {a, c});
		}
		int ref = max;

		while (min <= max) {
			int mid = (min + max) >> 1;
			if (dijkstra(mid)) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min == ref + 1 ? -1 : min);
		br.close();
	}

	static boolean dijkstra(int target) {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[] {start, 0});

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int node = now[0];
			int c = now[1];
			if (visited[node]) {
				continue;
			}
			if (node == end) {
				return c <= limit;
			}
			visited[node] = true;

			adjList[node].forEach(e -> {
				if (visited[e[0]] || e[1] > target) {
					return;
				}
				pq.add(new int[] {e[0], c + e[1]});
			});
		}
		return false;
	}
}
