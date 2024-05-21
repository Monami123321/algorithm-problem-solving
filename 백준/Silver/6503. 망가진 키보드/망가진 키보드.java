import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int m = Integer.parseInt(br.readLine());
			if (m == 0) {
				break;
			}
			char[] arr = br.readLine().toCharArray();
			int left = 0;
			int right = 0;
			int[] visited = new int[129];
			int ans = 0;
			while (right < arr.length && right >= left) {
				if (visited[arr[right]] == 0) {
					if (m == 0) {
						ans = Math.max(ans, right - left);
						if (--visited[arr[left++]] == 0) {
							m++;
						}
						continue;
					} else {
						m--;
						visited[arr[right++]]++;
					}

				} else {
					visited[arr[right++]]++;
				}
			}
			ans = Math.max(ans, right - left);
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
