

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;

	static int binarySearch(int key) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key)
				return 1;

			if (arr[mid] < key) {
				start = mid + 1;

			} else {
				end = mid - 1;

			}

		}
		return 0;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();

		}
		Arrays.sort(arr);
		int m = scanner.nextInt();
		for (int i = 0; i < m; i++) {
			System.out.println(binarySearch(scanner.nextInt()));

		}

		scanner.close();
	}

}
