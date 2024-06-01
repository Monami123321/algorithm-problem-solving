import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
		int[] tmp = new int[n];
		int[] lis = new int[n];
		int size = 0;
		Arrays.fill(tmp, Integer.MAX_VALUE);
		Arrays.fill(lis, Integer.MAX_VALUE);
		for (int i = 0; i < n; i++) {
			int index = Arrays.binarySearch(tmp, arr[i][1]);
			if (index < 0) {
				index = -(index + 1);
			}
			tmp[index] = arr[i][1];
			lis[i] = index;
			size = Math.max(size, index + 1);
		}
		Stack<Integer> stack = new Stack<>();
		int index = size - 1;
		for (int i = n - 1; i >= 0; i--) {
			if (lis[i] == index) {
				stack.push(i);
				index--;
			}
			if (index == -1) {
				break;
			}
		}
		boolean[] visited = new boolean[n];
		while (!stack.isEmpty()) {
			visited[stack.pop()] = true;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(n - size).append("\n");
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				sb.append(arr[i][0]).append("\n");
			}
		}
		System.out.print(sb);

		br.close();

	}
}
