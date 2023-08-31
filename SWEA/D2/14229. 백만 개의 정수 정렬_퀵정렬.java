
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution5 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input (20).txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
		Scanner scanner = new Scanner(System.in);
		int[] a = new int[1_000_000];

		for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextInt();
		}
		
		quickSort(a, 0, a.length-1);
		System.out.println(a[500000]);

		scanner.close();
	}

	static void quickSort(int[] arr, int left, int right) {
		if (right > left) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);

		}

		return;

	}

	static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];

		int L = left + 1;
		int R = right;

		while (L <= R) {
			while (L <= R && arr[L] <= pivot) {
				L++;
			}
			while (L <= R && arr[R] >= pivot) {
				R--;
			}

			if (L < R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}
		}
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;

	}

}
