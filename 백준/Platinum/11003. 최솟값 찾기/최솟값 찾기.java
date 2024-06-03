import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int startIndex = 1;
		while (startIndex < n) {
			startIndex <<= 1;
		}
		int treeSize = startIndex << 1;
		int[] segTree = new int[treeSize];
		Arrays.fill(segTree, Integer.MAX_VALUE);
		for (int i = 0; i < n; i++) {
			segTree[startIndex + i] = Integer.parseInt(st.nextToken());
		}

		for (int i = treeSize - 1; i > 1; i--) {
			segTree[i >> 1] = Math.min(segTree[i], segTree[i >> 1]);
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int left = i - l + 1;
			int right = i + startIndex;
			if (left < 0) {
				left = startIndex;
			} else {
				left += startIndex;
			}
			sb.append(query(segTree, left, right)).append(" ");
		}
		System.out.print(sb);

		br.close();
	}

	static int query(int[] segTree, int left, int right) {
		int res = Integer.MAX_VALUE;

		while (left < right) {
			if ((left & 1) == 0) {
				left >>= 1;
			} else {
				res = Math.min(res, segTree[left++]);
				left >>= 1;
			}
			if ((right & 1) == 0) {
				res = Math.min(res, segTree[right--]);
				right >>= 1;
			} else {
				right >>= 1;
			}
		}
		if (left == right) {
			res = Math.min(res, segTree[left]);
		}
		return res;
	}
}
