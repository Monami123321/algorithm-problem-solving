

import java.util.Scanner;

public class Main { // 백준 2559 수열


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int[] temperatures = new int[n];
		
		for (int i = 0; i < n; i++) {
			temperatures[i] = scanner.nextInt();
			
		}
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i <= n-k; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += temperatures[i+j];
				
			}
			max = Math.max(max, sum);		
		}
		
		System.out.println(max);
		

		
		scanner.close();
	}

}
