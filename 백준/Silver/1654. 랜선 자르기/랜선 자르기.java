import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int k = scanner.nextInt();
		int n = scanner.nextInt();
		
		int[] wlans = new int[k];
		for (int i = 0; i < k; i++) {
			wlans[i] = scanner.nextInt();
		}
		
		
		long start = 1;
		long end = Integer.MAX_VALUE;
		while(start<=end) {
			long mid = (start+end)/2;
			long sum = 0;	
			for (int j = 0; j < k; j++) {
				sum += wlans[j]/mid;
				
			}
			
			
			if(sum>=n) start = mid+1;
			if(sum<n) end = mid-1;
		}
		System.out.println(end);
		
		
		
		scanner.close();
	}

}
