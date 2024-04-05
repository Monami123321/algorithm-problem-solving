import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		boolean flag  = true;
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (now == -1) {
				flag = false;
				continue;
			}
			if (flag) {
				left = Math.min(left, now);
			} else {
				right = Math.min(right, now);
			}
		}
		System.out.println(left + right);
		br.close();
	}
}
