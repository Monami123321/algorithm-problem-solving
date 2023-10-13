import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static void swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
		return;
	}

	static boolean nextPermutation(int[] p) {
		int i = p.length - 1;
		while (i > 0 && p[i - 1] >= p[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = p.length - 1;
		while (p[i - 1] >= p[j]) {
			j--;
		}
		swap(p, i - 1, j);

		int k = p.length - 1;
		while (i < k) {
			swap(p, i++, k--);

		} // 오름차순됨

		return true;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;

		} // 정렬 생략 (초기화 이미 내가 함)

		do {

			for (int i = 0; i < n; i++) {
				sb.append(arr[i]).append(" ");

			}
			sb.append("\n");
		} while (nextPermutation(arr));

		System.out.println(sb);
		br.close();
	}

}
