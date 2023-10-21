import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int INF = 1 << 29;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] dist = new int[N + 1][N + 1];
		int[][] route = new int[N + 1][N + 1];

		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist.length; j++) {
				dist[i][j] = INF;

			}
			dist[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (dist[a][b] > c) {
				dist[a][b] = c;

				route[a][b] = a; // i 에서 j갈때 마지막으로 거친 곳

			}

		}

		for (int m = 1; m < dist.length; m++) {
			for (int s = 1; s < dist.length; s++) {
				for (int e = 1; e < dist.length; e++) {
					if (dist[s][e] > dist[s][m] + dist[m][e]) {
						dist[s][e] = dist[s][m] + dist[m][e];
						route[s][e] = route[m][e];

					}
				}

			}

		}
		for (int i = 1; i < dist.length; i++) {
			for (int j = 1; j < dist.length; j++) {
				if (dist[i][j] == INF) {
					dist[i][j] = 0;
				}
				sb.append(dist[i][j]).append(" ");

			}
			sb.append("\n");

		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i < route.length; i++) {
			for (int j = 1; j < route.length; j++) {
				if (route[i][j] == 0) {
					sb.append(0).append("\n");
					continue;
				} else {
					stack.push(j);
					int prev = route[i][j];
					while (prev != 0) {
						stack.push(prev);
						prev = route[i][prev];
					}
					sb.append(stack.size()).append(" ");
					while (!stack.isEmpty()) {
						sb.append(stack.pop()).append(" ");
					}
					sb.append("\n");
				}

			}

		}

		System.out.print(sb);

		br.close();
	}

}
