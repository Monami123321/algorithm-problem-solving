import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static void reverse() {
		int tmp = head;
		head = tail;
		tail = tmp;
		flag = !flag;
	}

	static boolean drop() {
		if (flag) {
			if (tail < head++)
				return false;
		} else {

			if (tail > head--)
				return false;
		}
		return true;
	}

	static int head, tail;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testCases = Integer.parseInt(br.readLine());

		outer: for (int tc = 0; tc < testCases; tc++) {
			String cmd = br.readLine();
			int len = cmd.length();
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine(), "][,");
			if (n == 0) {
				for (int i = 0; i < len; i++) {
					if (cmd.charAt(i) == 'D') {
						sb.append("error").append("\n");
						continue outer;
					}

				}

				sb.append("[]").append("\n");
				continue outer;

			}
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			head = 0;
			tail = n - 1;
			flag = true; // true 정방 false 역방

			for (int i = 0; i < len; i++) {
				if (cmd.charAt(i) == 'R') {
					reverse();
				} else {
					if (!drop()) {
						sb.append("error").append("\n");
						continue outer;
					}
				}

			}

			if (flag && head > tail) {
				sb.append("[]").append("\n");
				continue outer;

			} else if (!flag && head < tail) {
				sb.append("[]").append("\n");
				continue outer;
			}

			if (flag) {
				sb.append("[");
				for (int i = head; i < tail; i++) {
					sb.append(arr[i]).append(",");
				}
				sb.append(arr[tail]).append("]").append("\n");
			} else {
				sb.append("[");
				for (int i = head; i > tail; i--) {
					sb.append(arr[i]).append(",");
				}
				sb.append(arr[tail]).append("]").append("\n");
			}

		}
		System.out.print(sb);

		br.close();
	}

}
