import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] budgets = new int[n];
		st = new StringTokenizer(br.readLine());

		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
			sum += budgets[i];
			max = Math.max(max, budgets[i]);
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		if (sum <= m) {
			System.out.println(max);
		} else {

			int start = 1;
			int end = max - 1;

			while (start <= end) {
				int mid = (start + end) / 2;
				int tmp = 0;

				for (int i = 0; i < n; i++) {
					if (budgets[i] <= mid) {
						tmp += budgets[i];
					} else {
						tmp += mid;
					}

				}

				if (tmp > m)
					end = mid - 1;
				else
					start = mid + 1;

			}
			System.out.println(end);

		}

		br.close();
	}

}
