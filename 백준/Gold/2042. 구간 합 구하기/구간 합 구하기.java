import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int startIndex = 1;
		while (startIndex <= n) {
			startIndex <<= 1;
		}
		int treeSize = startIndex << 1;
		long[] segTree = new long[treeSize];
		for (int i = 0; i < n; i++) {
			segTree[startIndex + i] = Long.parseLong(br.readLine());
		}
		for (int i = treeSize - 1; i > 1; i--) {
			segTree[i >> 1] += segTree[i];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m + q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int index = Integer.parseInt(st.nextToken()) - 1 + startIndex;
				long next = Long.parseLong(st.nextToken());

				long diff = next - segTree[index];

				while (index > 0) {
					segTree[index] += diff;
					index >>= 1;
				}

			} else {
				int start = Integer.parseInt(st.nextToken()) - 1 + startIndex;
				int end = Integer.parseInt(st.nextToken()) - 1 + startIndex;
				sb.append(getSum(segTree, start, end)).append("\n");
			}

		}
		System.out.print(sb);

		br.close();
	}

	static long getSum(long[] segTree, int start, int end) {
		long sum = 0;
		while (end > start) {
			if ((start & 1) == 0) {
				start >>= 1;
			} else {
				sum += segTree[start++];
				start >>= 1;
			}
			if ((end & 1) == 0) {
				sum += segTree[end--];
				end >>= 1;
			} else {
				end >>= 1;
			}
		}
		if (start == end) {
			sum += segTree[start];
		}
		return sum;
	}
}
