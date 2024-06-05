import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cost = new int[n + 1];
		int[] indegree = new int[n + 1];
		List<Integer>[] adjList = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			while (true) {
				int next = Integer.parseInt(st.nextToken());
				if (next == -1) {
					break;
				}
				adjList[next].add(i);
				indegree[i]++;
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		int[] ans = new int[n];
		for (int i = 1; i < n + 1; i++) {
			if (indegree[i] == 0) {
				queue.add(new int[] {i, cost[i]});
				ans[i - 1] = cost[i];
			}
		}
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int node = now[0];
			int c = now[1];
			adjList[node].forEach(e -> {
				ans[e - 1] = Math.max(ans[e - 1], c + cost[e]);
				if (--indegree[e] == 0) {
					queue.add(new int[] {e, ans[e - 1]});
				}
			});
		}
		System.out.print(Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
		br.close();
	}
}
