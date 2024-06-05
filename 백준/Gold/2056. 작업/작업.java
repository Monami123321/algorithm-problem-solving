import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] adjList = new ArrayList[n + 1];
		int[] indegree = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		int[] cost = new int[n + 1];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				int prev = Integer.parseInt(st.nextToken());
				adjList[prev].add(i);
				++indegree[i];
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		int[] ans = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			if (indegree[i] == 0) {
				queue.add(new int[] {i, cost[i]});
				ans[i] = cost[i];
			}
		}
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int node = now[0];
			int c = now[1];
			adjList[node].forEach(e -> {
				ans[e] = Math.max(ans[e], cost[e] + c);
				if (--indegree[e] == 0) {
					queue.add(new int[] {e, ans[e]});
				}
			});
		}
		System.out.println(Arrays.stream(ans).max().getAsInt());

		br.close();
	}
}
