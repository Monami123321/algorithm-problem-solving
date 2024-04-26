import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int left = 0;
		int right = 0;
		int ans = Integer.MAX_VALUE;
		while (left <= right && right < n) {
			int diff = arr[right] - arr[left];
			if (diff >= m) {
				ans = Math.min(diff, ans);
				left++;
			} else {
				right++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}

