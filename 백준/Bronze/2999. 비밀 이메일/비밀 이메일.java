import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int len = word.length();
		int n = (int)Math.sqrt(len);
		int m = 0;
		for (int i = n; i >= 1; i--) {
			if (len % i == 0) {
				n = i;
				m = len / n;
				break;
			}
		}
		char[][] arr = new char[n][m];
		int index = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[j][i] = word.charAt(index++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]);
			}
		}
		System.out.print(sb);
		br.close();
	}
}
