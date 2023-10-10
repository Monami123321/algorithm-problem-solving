import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] memo;

	static long getPermOrder(int[] arr) {
		long ans = 0L;
		int len = arr.length;
		boolean[] visited = new boolean[len + 1];

		for (int i = 0; i < arr.length - 1; i++) {
			int target = arr[i];
			int tmp = 0;
			visited[target] = true;
			for (int j = 1; j < target; j++) {
				if (visited[j])
					continue;
				tmp++;

			}
			ans += memo[len - (i + 1)] * tmp;

		}
		return ans + 1;

	}

	static int[] getPerm(long k, int n) {
		int[] res = new int[n];
		int resIndex = 0;
		boolean[] visited = new boolean[n + 1];

		outer: for (int i = n; i >= 1; i--) {
			for (int j = 1; j < visited.length; j++) {
				if (visited[j]) {
					continue;
				}
				if (k > memo[i - 1]) {
					k -= memo[i - 1];
				} else {
					res[resIndex++] = j;
					visited[j] = true;
					continue outer;
				}

			}

		}

		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		memo = new long[n + 1];
		memo[1] = memo[0] = 1;
		for (int i = 2; i < memo.length; i++) {
			memo[i] = memo[i - 1] * i;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());

		if (Integer.parseInt(st.nextToken()) == 1) {
			long k = Long.parseLong(st.nextToken());
			int[] res = getPerm(k, n);
			for (int tmp : res) {
				sb.append(tmp).append(" ");
			}

		} else {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());

			}
			sb.append(getPermOrder(arr));

		}

		System.out.println(sb);

		br.close();
	}

}
