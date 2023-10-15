import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();

		// KMP ㅡ> 갱신을 중복되지 않게 조절하면 됨

		// 실패함수 구성
		int[] pi = new int[pattern.length()];

		int j = 0;
		for (int i = 1; i < pi.length; i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}

			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}

		} // 실패함수 만들기 끝

		// KMP 시작
		j = 0;
		int cnt = 0; // 텍스트 안에 패턴이 몇 번 등장했는지 확인하는 변수
		for (int i = 0; i < text.length(); i++) {
			while (j > 0 && pattern.charAt(j) != text.charAt(i)) {
				j = pi[j - 1];
			}

			if (pattern.charAt(j) == text.charAt(i)) {
				j++;
				if (j == pattern.length()) {
					cnt++;
					// j = pi[j-1]; 원래였으면 이건데 문제 요구가 겹치는 것 없이 탐색임
					j = 0;

				}
			}

		}
		System.out.println(cnt);

		br.close();
	}

}
