import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[] visited;
	static int MASK;
	static int BIT_CNT;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[1 << n];
		MASK = (1 << n) - 1;
		BIT_CNT = Integer.bitCount(MASK);
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << n) - 1; i++) {
			if (visited[~i & MASK]) {
				continue;
			}
			visited[i] = true;
			ans = Math.min(ans, getDiff(i));
		}
		System.out.println(ans);
		br.close();
	}

	static int getDiff(int n) {
		int sum0 = 0;
		int sum1 = 0;
		int len1 = Integer.bitCount(n);
		int len0 = BIT_CNT - len1;
		int[] arr0 = new int[len0];
		int[] arr1 = new int[len1];
		int index0 = 0;
		int index1 = 0;
		int tmp = BIT_CNT - 1;
		while (tmp >= 0) {
			if ((n & 1 << tmp) != 0) {
				arr1[index1++] = BIT_CNT - 1 - tmp;
				--tmp;
			} else {
				arr0[index0++] = BIT_CNT - 1 - tmp;
				--tmp;
			}
		}

		for (int i = 0; i < len0 - 1; i++) {
			for (int j = i + 1; j < len0; j++) {
				sum0 += map[arr0[i]][arr0[j]] + map[arr0[j]][arr0[i]];
			}
		}

		for (int i = 0; i < len1 - 1; i++) {
			for (int j = i + 1; j < len1; j++) {
				sum1 += map[arr1[i]][arr1[j]] + map[arr1[j]][arr1[i]];
			}
		}
		return Math.abs(sum0 - sum1);
	}
}
