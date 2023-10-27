import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCases = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCases; tc++) {
			long n = Integer.parseInt(br.readLine());

			boolean[] visited = new boolean[10];

			int ans = 1;
			outer: while (true) {
				long tmp = n * ans;
				while (tmp > 0) {
					visited[(int) (tmp % 10)] = true;
					tmp /= 10;
				}

				for (int i = 0; i < visited.length; i++) {
					if (!visited[i]) {
						ans++;
						continue outer;

					}

				}
				break;

			}
			sb.append("#").append(tc).append(" ").append(ans*n).append("\n");

		}
		System.out.print(sb);

		br.readLine();
	}

}
