import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[n][n];
		for (int i = 0; i < adjMatrix.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < adjMatrix.length; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		int[][] ansMatrix = new int[n][n];

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];

			for (int j = 0; j < adjMatrix.length; j++) {
				if (adjMatrix[i][j] == 1) {
					queue.add(j);
					visited[j] = true;
				}

			}

			while (!queue.isEmpty()) {
				int node = queue.poll();

				for (int j = 0; j < n; j++) {
					if (visited[j] || adjMatrix[node][j] == 0) {
						continue;
					}
					visited[j] = true;
					queue.add(j);

				}
			}

			for (int j = 0; j < visited.length; j++) {
				if (visited[j]) {
					ansMatrix[i][j] = 1;
				}

			}

		}

		for (int i = 0; i < ansMatrix.length; i++) {
			for (int j = 0; j < ansMatrix.length; j++) {
				sb.append(ansMatrix[i][j]).append(" ");

			}
			sb.append("\n");

		}
		System.out.println(sb);

		br.close();
	}

}
