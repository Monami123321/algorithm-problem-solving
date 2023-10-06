import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = 360000;
		String ans = "impossible";

		int[] clock1 = new int[m * 2];
		int[] clock2 = new int[m];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int index = Integer.parseInt(st.nextToken());
			clock1[index] = 1;
			clock1[index + m] = 1;

		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int index = Integer.parseInt(st.nextToken());
			clock2[index] = 1;

		}

		int[] pi = new int[m];
		int j = 0;
		for (int i = 1; i < m; i++) {
			while (j > 0 && clock2[i] != clock2[j]) {
				j = pi[j - 1];
			}

			if (clock2[i] == clock2[j]) {
				pi[i] = ++j;
			}

		}
		j = 0;
		for (int i = 0; i < clock1.length; i++) {
			while (j > 0 && clock1[i] != clock2[j]) {
				j = pi[j - 1];
			}

			if (clock1[i] == clock2[j]) {
				j++;
				if (j == m) {
					ans = "possible";
					break;

				}
			}

		}

		System.out.println(ans);

		br.close();
	}

}
