import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 1;
	static int k;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		memo = new int[k << 1];
		Arrays.fill(memo, -1);
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(arr);
		System.out.println(memo[k]);

		br.close();
	}

	static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		int mid = arr.length - 1 >> 1;
		sort(arr, tmp, 0, arr.length - 1);
	}

	static void sort(int[] arr, int[] tmp, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = (left + right) >> 1;
		sort(arr, tmp, left, mid);
		sort(arr, tmp, mid + 1, right);
		merge(arr, tmp, left, mid, right);
	}

	static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
		if (cnt > k) {
			return;
		}
		int index = left;
		int l = left;
		int r = mid + 1;

		while (l <= mid && r <= right) {
			if (arr[l] <= arr[r]) {
				tmp[index++] = arr[l++];
			} else {
				tmp[index++] = arr[r++];
			}
		}
		if (l != mid + 1) {
			while (l <= mid) {
				tmp[index++] = arr[l++];
			}
		} else {
			while (r <= right) {
				tmp[index++] = arr[r++];
			}
		}
		for (int i = left; i <= right; i++) {
			if (cnt > k) {
				return;
			}
			memo[cnt++] = arr[i] = tmp[i];
		}

	}

}
