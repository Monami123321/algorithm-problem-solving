import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int startIndex = 1;
		while (startIndex < n) {
			startIndex <<= 1;
		}
		int treeSize = startIndex << 1;
		long[] segTree = new long[treeSize];
		Arrays.fill(segTree, 1);
		for (int i = 0; i < n; i++) {
			segTree[startIndex + i] = Integer.parseInt(br.readLine());
		}
		for (int i = treeSize - 1; i > 1; i--) {
			segTree[i >> 1] *= segTree[i];
			segTree[i >> 1] %= MOD;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m + q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int index = Integer.parseInt(st.nextToken()) - 1 + startIndex;
				// long next = Long.parseLong(st.nextToken());
				segTree[index] = Long.parseLong(st.nextToken());
				while (index > 1) {
					segTree[index >> 1] = (segTree[index] * segTree[index ^ 1]) % MOD;
					index >>= 1;
				}
			} else {
				int start = Integer.parseInt(st.nextToken()) - 1 + startIndex;
				int end = Integer.parseInt(st.nextToken()) - 1 + startIndex;
				sb.append(getProduct(segTree, start, end)).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

	static long getProduct(long[] segTree, int start, int end) {
		long res = 1;
		while (end > start) {
			if ((start & 1) == 0) {
				start >>= 1;
			} else {
				res *= segTree[start++];
				start >>= 1;
				res %= MOD;
			}

			if ((end & 1) == 0) {
				res *= segTree[end--];
				end >>= 1;
				res %= MOD;
			} else {
				end >>= 1;
			}
		}
		if (start == end) {
			res *= segTree[start];
			res %= MOD;
		}
		return res;
	}
}
