import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (tc-- > 0) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n + m][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				arr[n + i][0] = 1;
				arr[n + i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, (a, b) -> {
				if (a[1] != b[1]) {
					return a[1] - b[1];
				}
				return b[0] - a[0];
			});
			if (arr[n + m - 1][0] == 0) {
				sb.append("S\n");
			} else {
				sb.append("B\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
