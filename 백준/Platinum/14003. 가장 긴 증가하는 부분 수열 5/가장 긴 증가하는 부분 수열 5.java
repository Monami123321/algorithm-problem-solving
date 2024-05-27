import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] tmp = new int[n];
		int[] lis = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			tmp[i] = Integer.MAX_VALUE;
		}
		int size = 0;
		for (int i = 0; i < n; i++) {
			int index = Arrays.binarySearch(tmp, arr[i]);
			if (index < 0) {
				index = -(index + 1);
			}
			tmp[index] = arr[i];
			lis[i] = index;
			if (size < index + 1) {
				size = index + 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(size).append("\n");
		Stack<Integer> stack = new Stack<>();
		size--;
		for (int i = n - 1; i >= 0; i--) {
			if (lis[i] == size) {
				stack.push(arr[i]);
				size--;
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.print(sb);
		br.close();
	}
}
