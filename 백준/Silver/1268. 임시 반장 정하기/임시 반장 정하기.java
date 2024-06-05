import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[n];
		int[][] map = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (isFriend(map[i], map[j])) {
					cnt[i]++;
					cnt[j]++;
				}
			}
		}
		int ans = 1;
		int max = cnt[0];
		for (int i = 1; i < n; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				ans = i + 1;
				
			}
		}
		System.out.println(ans);
		br.close();
	}

	static boolean isFriend(int[] arr, int[] arr2) {
		for (int i = 0; i < 5; i++) {
			if (arr[i] == arr2[i]) {
				return true;
			}
		}
		return false;
	}
}
