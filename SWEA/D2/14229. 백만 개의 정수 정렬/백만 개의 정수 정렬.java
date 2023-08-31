import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
			return;
		}
		
		return;

	}

	static void merge(int[] arr, int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int index = 0;
		int[] sortedArr = new int[right-left+1];

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				sortedArr[index++] = arr[L++];
			} else {
				sortedArr[index++] = arr[R++];
			}

		}

		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sortedArr[index++] = arr[L++];
			}
		} else {
			for (int i = R; i <= right; i++) {
				sortedArr[index++] = arr[R++];

			}
		}

		for (int i = left,tmpIndex=0; i <= right; i++) {
			arr[i] = sortedArr[tmpIndex++];
		}

	}

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input (20).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] a = new int[1_000_000];


		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		//mergeSort(a, 0, 1_000_000-1);
		mergeSort(a, 0, a.length-1);
		
		
		System.out.println(a[500_000]);

		br.close();
	}
}