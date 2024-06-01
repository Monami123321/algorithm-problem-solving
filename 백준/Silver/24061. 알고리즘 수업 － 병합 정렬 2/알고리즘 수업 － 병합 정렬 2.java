import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static int k, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		cnt = 0;
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(arr);
		if (cnt < k) {
			System.out.println(-1);
		} else {
			System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
		br.close();
	}

	static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		sort(arr, tmp, 0, arr.length - 1);
	}

	static void sort(int[] arr, int[] tmp, int left, int right) {
		if (cnt == k) {
			return;
		}
		if (left == right) {
			return;
		}
		int mid = (left + right) >> 1;
		sort(arr, tmp, left, mid);
		sort(arr, tmp, mid + 1, right);
		merge(arr, tmp, left, mid, right);
	}

	static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
		if (cnt == k) {
			return;
		}
		int l = left;
		int r = mid + 1;
		int index = l;
		while (l <= mid && r <= right) {
			if (arr[l] <= arr[r]) {
				tmp[index++] = arr[l++];
			} else {
				tmp[index++] = arr[r++];
			}
		}
		while (l <= mid) {
			tmp[index++] = arr[l++];
		}
		while (r <= right) {
			tmp[index++] = arr[r++];
		}

		for (int i = left; i <= right; i++) {
			if (cnt == k) {
				return;
			}
			arr[i] = tmp[i];
			cnt++;
		}
	}
}
