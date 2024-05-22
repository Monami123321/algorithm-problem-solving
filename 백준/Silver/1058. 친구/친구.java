import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'Y') {
					cnt++;
				} else {
					if (check(map, i, j, n)) {
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
		br.close();
	}

	static boolean check(char[][] map, int a, int b, int n) {
		if (a == b) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			if (map[i][a] == 'Y' && map[i][b] == 'Y') {
				return true;
			}
		}
		return false;
	}
}
