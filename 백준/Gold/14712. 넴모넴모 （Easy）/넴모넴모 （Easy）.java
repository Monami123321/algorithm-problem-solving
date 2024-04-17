import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		int VAL = (3 << m) + 3;
		
		outer:for (int i = 0; i < 1 << m * n; i++) {
			for (int j = 0; j < n-1; j++) {
				for (int k = 0; k < m - 1; k++) {
					int now = VAL << (j * m + k);
					if ((i & now) == now) {
						continue outer;
					}

				}
			}
			ans++;
		}
		System.out.println(ans);

		br.close();
	}
}
