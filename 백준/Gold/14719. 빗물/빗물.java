import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] map = new int[h][w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			int height = Integer.parseInt(st.nextToken());
			for (int j = 0; j < height; j++) {
				map[h - 1 - j][i] = 1;
			}
		}
		int ans = 0;
		for (int i = 0; i < h; i++) {
			ans += cal(map[i]);
		}
		System.out.println(ans);
		br.close();
	}

	static int cal(int[] arr) {
		int cnt = 0;
		int ref = 0;
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				ref++;
				if (ref == 2) {
					res += cnt;
					cnt = 0;
					ref = 1;
				}
			} else {
				if (ref == 0) {
					continue;
				}
				cnt++;
			}
		}
		return res;
	}
}
