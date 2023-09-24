import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		List<int[]>[] adjList= new ArrayList[V+1];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
			
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[a].add(new int[] {b,w});
			
		}
		int[] minEdge = new int[V + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[start] = 0;

		boolean[] visited = new boolean[V + 1];

		int pick = 0;
		while (pick < V) {
			int min = Integer.MAX_VALUE;
			int index = -1;

			for (int i = 1; i < minEdge.length; i++) {
				if(visited[i]) continue;
				if (min > minEdge[i]) {
					min = minEdge[i];
					index = i;
				}
			}
			if(index == -1) break;
			visited[index] = true;
			pick++;

			for (int i = 0; i < adjList[index].size(); i++) {
				if (visited[adjList[index].get(i)[0]])
					continue;
				minEdge[adjList[index].get(i)[0]] = Math.min(minEdge[adjList[index].get(i)[0]], minEdge[index] + adjList[index].get(i)[1]);

			}

		}
//		System.out.println(Arrays.toString(minEdge));
		
		for (int i = 1; i < V+1; i++) {
			if (minEdge[i] != Integer.MAX_VALUE)
				sb.append(minEdge[i]).append("\n");
			else
				sb.append("INF\n");
			
		}
		System.out.println(sb);

		br.close();

	}

}
