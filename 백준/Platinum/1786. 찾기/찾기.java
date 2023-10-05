import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String target = br.readLine();
		String pattern = br.readLine();

		int n = target.length(); // 총 문자열 길이
		int m = pattern.length(); // 패턴 길이

		int[] pi = new int[m];

		int j = 0;
		for (int i = 1; i < m; i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}

			if (pattern.charAt(j) == pattern.charAt(i)) {
				pi[i] = ++j;
			}

		}

		j = 0;
		int cnt = 0; // 패턴이 몇번 나타나는지 세기
		List<Integer> list = new ArrayList<>(); // 몇번째 인덱스에서 나타났는지 ㅡ> i-m+1부터 시작해서 m개가 일치할 것
		for (int i = 0; i < n; i++) {
			while (j > 0 && pattern.charAt(j) != target.charAt(i)) {
				j = pi[j - 1];
			}

			if (pattern.charAt(j) == target.charAt(i)) {
				j++;
				if (j == m) { // 패턴 찾음
					cnt++; // 개수 올리고
					list.add(i - m + 1); // 인덱스 추가하고
					j = pi[j - 1];

				}
			}

		}
		sb.append(cnt).append(" \n");
		for (int tmp : list) {
			sb.append(tmp + 1).append(" "); // 문제 요구가 인덱스가 아니라 x번째 문자라서 +1해줌

		}

		System.out.println(sb);

		br.close();
	}

}
