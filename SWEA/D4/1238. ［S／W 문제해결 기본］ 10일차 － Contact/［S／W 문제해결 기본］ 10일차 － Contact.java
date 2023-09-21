import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer> lastPerson;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());

			int E = Integer.parseInt(st.nextToken());
			int startPoint = Integer.parseInt(st.nextToken());

			graph = new int[101][101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1;

			}
			Queue<Integer> queue = new LinkedList<>();
			int[] level = new int[101];
			int levelIndex = 1;
			int[] levelNodeNum = new int[100];
			level[startPoint] = levelIndex;
			queue.add(startPoint);
			levelNodeNum[1] = 1;
			
			boolean[] visited = new boolean[101];
			visited[startPoint] =true;

			while (!queue.isEmpty()) {
				levelIndex++;
				int nodeNum = 0;
				
				for (int i = 0; i < levelNodeNum[levelIndex-1]; i++) {
					int node = queue.poll();
					for (int j = 1; j <= 100; j++) {
						if(visited[j] ||graph[node][j] == 0) 
							continue;
						queue.add(j);
						visited[j] = true;
						level[j] = levelIndex;
						nodeNum++;
					}
				}
				levelNodeNum[levelIndex] = nodeNum;

			}
//			System.out.println(Arrays.toString(level));
//			System.out.println(Arrays.toString(visited));
			
			int maxIndex = 0;
			int maxNum = 0;
			for (int i = 1; i < level.length; i++) {
				maxIndex = Math.max(maxIndex, level[i]);

			}
			
			for (int i = 0; i < level.length; i++) {
				if(level[i] == maxIndex) {
					maxNum = Math.max(maxNum, i);
				}
				
				
			}

			System.out.printf("#%d %d\n",tc,maxNum);
			
			
		}

		br.close();
	}

}
