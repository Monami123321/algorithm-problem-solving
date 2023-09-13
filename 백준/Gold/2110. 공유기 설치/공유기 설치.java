import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int c = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();

		}
		Arrays.sort(arr);

		int start = 1;
		int end = arr[n - 1] - arr[0];

		while (start <= end) {
			int mid = (start + end) / 2;
			int index = 0;
			int sum = 1;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] - arr[index] >= mid) {
					index = i;
					sum++;
				}

			}
			
			if(sum>=c) start = mid+1;
			else end = mid-1;

		}
		System.out.println(end);
		

		scanner.close();
	}

}
