import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
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
		for (int i = treeSize - 1; i > 0; i--) {
			segTree[i >> 1] = Math.min(segTree[i], segTree[i ^ 1]);
		}
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int index = Integer.parseInt(st.nextToken()) + startIndex - 1;
				int val = Integer.parseInt(st.nextToken());
				update(segTree, index, val);
			} else {
				int left = Integer.parseInt(st.nextToken()) + startIndex - 1;
				int right = Integer.parseInt(st.nextToken()) + startIndex - 1;
				sb.append(query(segTree, left, right)).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

	static void update(int[] segTree, int index, int val) {
		segTree[index] = val;
		while (index > 0) {
			segTree[index >> 1] = Math.min(segTree[index], segTree[index ^ 1]);
			index >>= 1;
		}
	}

	static int query(int[] segTree, int left, int right) {
		int res = Integer.MAX_VALUE;
		while (right > left) {
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
		if (right == left) {
			res = Math.min(res, segTree[left]);
		}
		return res;
	}
}
