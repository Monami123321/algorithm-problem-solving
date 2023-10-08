import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testCases = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCases; tc++) {
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();

			int len1 = str1.length();
			int len2 = str2.length();

			int GCD = 1;
			for (int i = Math.min(len1, len2); i >= 1; i--) {
				if (len1 % i == 0 && len2 % i == 0) {
					GCD = i;
					break;
				}

			}
			int LCM = (len1 / GCD) * (len2 / GCD) * GCD;
			String ans = "yes";
			for (int i = 0; i < LCM; i++) {
				if (str1.charAt(i % len1) != str2.charAt(i % len2)) {
					ans = "no";
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

		br.close();
	}

}
