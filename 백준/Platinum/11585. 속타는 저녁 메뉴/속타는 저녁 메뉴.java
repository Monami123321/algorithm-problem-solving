import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[] target = new char[n * 2]; // 환형배열 구성
		char[] pattern = new char[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			target[i] = st.nextToken().charAt(0);
			target[i + n] = target[i];

		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pattern[i] = st.nextToken().charAt(0);

		}

		// PI 배열 만들기
		int m = pattern.length;
		int[] pi = new int[m];
		int j = 0;

		for (int i = 1; i < m; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = pi[j - 1];
			}

			if (pattern[i] == pattern[j]) {
				pi[i] = ++j;

			}

		}

		// KMP 진행 , 환형배열 전부 순회하면서 (룰렛을 돌리는 상황)
		j = 0;
		int cnt = 0;
		for (int i = 0; i < m * 2 - 1; i++) {
			while (j > 0 && pattern[j] != target[i]) {
				j = pi[j - 1];
			}

			if (pattern[j] == target[i]) {
				j++;
				if (j == m) {
					cnt++;
					j = pi[j - 1];

				}
			}
		}
		// cnt 와 n 기약분수 형태로 정리
		int index = Math.min(cnt, n);
		for (int i = index; i >= 1; i--) {
			if (cnt % index == 0 && n % index == 0) {
				cnt /= index;
				n /= index;
				break;
			}

		}

		System.out.printf("%d/%d", cnt, n);

		br.close();
	}

}
