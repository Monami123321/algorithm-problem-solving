import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			String pattern = br.readLine();
			String text = br.readLine();
			int m = pattern.length();
			int n = text.length();
			int ans = 0;

			int[] pi = new int[m];
			int j = 0;
			for (int i = 1; i < pi.length; i++) {
				while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
					j = pi[j - 1];
				}

				if (pattern.charAt(i) == pattern.charAt(j)) {
					pi[i] = ++j;
				}

			}
			j = 0;
			for (int i = 0; i < n; i++) {
				while (j > 0 && pattern.charAt(j) != text.charAt(i)) {
					j = pi[j - 1];
				}

				if (pattern.charAt(j) == text.charAt(i)) {
					j++;
					if (j == m) {
						ans++;
						j = pi[j - 1];
					}
				}

			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

		br.close();

	}

}
