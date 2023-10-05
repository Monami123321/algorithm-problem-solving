import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String target = br.readLine(); // 검색 수행할 문자열
		String pattern = br.readLine(); // 찾을 패턴
		target = target.replaceAll("[0-9]", "");

		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = pi[j - 1];
			}

			if (pattern.charAt(j) == pattern.charAt(i)) {
				pi[i] = ++j;
			}

		} // pi배열 만들기 끝

		j = 0;
		int ans = 0;
		for (int i = 0; i < target.length(); i++) {

			while (j > 0 && pattern.charAt(j) != target.charAt(i)) {
				j = pi[j - 1];
			}

			if (pattern.charAt(j) == target.charAt(i)) {
				j++;

				if (j == pattern.length()) {
					ans = 1;
				}
			}
		}

		System.out.println(ans);

		br.close();
	}

}
