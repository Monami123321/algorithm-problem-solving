import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	static boolean nextPermutation(int[] arr) {
		int i = arr.length - 1;

		while (i > 0 && arr[i - 1] >= arr[i])
			i--;
		if (i == 0) {
			return false;
		}

		int j = arr.length - 1;

		while (arr[i - 1] >= arr[j])
			j--;
		swap(arr, i - 1, j);

		int k = arr.length - 1;
		while (i < k) {
			swap(arr, i++, k--);
		}
		return true;

	}

	static long getNum(int[] arr) {
		long res = 0;
		for (int i = 0; i < arr.length; i++) {
			res *= 10;
			res += arr[i];
		}

		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String tmp = st.nextToken();
		int[] arr = new int[tmp.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = tmp.charAt(i) - '0';

		}
		int target = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		if (arr[0] == 0) {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != 0) {
					swap(arr, 0, i);
					break;
				}

			}
		}
		long prev = -1;
		long now = 0;
		do {
			now = getNum(arr);
			if (now >= target) {
				break;

			}
			prev = now;

		} while (nextPermutation(arr));

		System.out.println(prev);

		br.close();
	}

}
