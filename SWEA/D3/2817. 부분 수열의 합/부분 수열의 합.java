import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCases; tc++) {
			st = new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken());
			int k =Integer.parseInt(st.nextToken());
			int ans = 0;
			
			
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < (1<<n); i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if((i & (1<<j))>0) {
						sum += arr[n-1-j];	
					}	
				}
				if (sum == k) ans++;
			}
			System.out.printf("#%d %d\n",tc,ans);	
		}
		br.close();
	}

}
