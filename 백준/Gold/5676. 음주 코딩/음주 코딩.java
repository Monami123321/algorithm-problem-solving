import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (true) {
			String tmp = br.readLine();
			if (tmp == null) {
				break;
			}
			st = new StringTokenizer(tmp);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int input = Integer.parseInt(st.nextToken());
				if (input != 0) {
					input = input > 0 ? 1 : -1;
				}
				arr[i] = input;
			}
			int startIndex = 1;
			while (n > startIndex) {
				startIndex <<= 1;
			}
			int treeSize = startIndex << 1;
			int[] segTree = new int[treeSize];
			Arrays.fill(segTree, 1);
			for (int i = 0; i < n; i++) {
				segTree[startIndex + i] = arr[i];
			}
			for (int i = treeSize - 1; i > 1; i--) {
				segTree[i >> 1] *= segTree[i];
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				if (cmd == 'C') {
					int index = Integer.parseInt(st.nextToken());
					int val = Integer.parseInt(st.nextToken());
					update(segTree, startIndex + index - 1, val);
				} else {
					int left = Integer.parseInt(st.nextToken()) + startIndex - 1;
					int right = Integer.parseInt(st.nextToken()) + startIndex - 1;
					int res = query(segTree, left, right);

					if (res == 0) {
						sb.append(0);
					} else if (res == 1) {
						sb.append('+');
					} else {
						sb.append('-');
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);

		br.close();
	}

	static void update(int[] segTree, int index, int val) {
		if (val != 0) {
			val = val > 0 ? 1 : -1;
		}
		if (segTree[index] == val) {
			return;
		}
		segTree[index] = val;
		while (index > 0) {
			segTree[index >> 1] = segTree[index] * segTree[index ^ 1];
			index >>= 1;
		}
	}

	static int query(int[] segTree, int left, int right) {
		int res = 1;
		while (right > left) {
			if (res == 0) {
				return res;
			}
			if ((left & 1) == 0) {
				left >>= 1;
			} else {
				res *= segTree[left++];
				left >>= 1;
			}

			if ((right & 1) == 0) {
				res *= segTree[right--];
				right >>= 1;
			} else {
				right >>= 1;
			}
		}
		if (left == right) {
			res *= segTree[left];
		}
		return res;
	}
}
