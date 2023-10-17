import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		List<int[]>[] adjList = new ArrayList[n + 1];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<int[]>();

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new int[] { to, weight });

		}

		st = new StringTokenizer(br.readLine());
		int targetFrom = Integer.parseInt(st.nextToken());
		int targetTo = Integer.parseInt(st.nextToken());

		Long[] minEdges = new Long[n + 1];
		for (int i = 1; i < minEdges.length; i++) {
			minEdges[i] = Long.MAX_VALUE;

		}

		minEdges[targetFrom] = 0L;

		boolean[] visited = new boolean[n + 1];

		int pick = 0;
		while (pick < n) {
			int minIndex = -1;
			long min = Long.MAX_VALUE;

			for (int i = 1; i < minEdges.length; i++) {
				if (visited[i])
					continue;
				if (minEdges[i] < min) {

					minIndex = i;
					min = minEdges[i];

				}

			}
			if(minIndex == targetTo) {
				break;
			}

			pick++;
			visited[minIndex] = true;

			for (int[] tmp : adjList[minIndex]) {
				if (visited[tmp[0]])
					continue;
				minEdges[tmp[0]] = Math.min(minEdges[tmp[0]], min + tmp[1]);

			}

		}

		System.out.println(minEdges[targetTo]);

		br.close();
	}

}
