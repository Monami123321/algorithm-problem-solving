

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static void binarySearch(int[] arr, int start, int end, int key) {
		int mid = (start+end)/2;
		
		if(arr[mid]==key) {
			sb.append(1).append(" ");
			return;
		}
		if(start>end) {
			sb.append(0).append(" ");
			return;
		}
		
		if(arr[mid]<key) {
			binarySearch(arr, mid+1, end, key);
		} else {
			binarySearch(arr, start, mid-1, key);
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr);
		
		int m = scanner.nextInt();
		
		for(int i = 0; i<m; i++) {
			binarySearch(arr, 0, n-1, scanner.nextInt());
				
		}
		
		System.out.println(sb);
		
		
		
		
		
		scanner.close();
	}
}