import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] left = st.nextToken().toCharArray();
		char[] right = st.nextToken().toCharArray();
		if (left.length < right.length) {
			System.out.println(0);
			return;
		}
		int index = 0;
		int ans = 0;
		while (index < left.length) {
			if (left[index] == right[index]) {
				if (left[index] == '8') {
					ans++;
					index++;
				} else {
					index++;
				}
			} else {
				break;
			}
		}
		System.out.println(ans);
		br.close();
	}
}
