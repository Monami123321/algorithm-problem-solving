import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int GCD = Integer.parseInt(st.nextToken());
		int LCM = Integer.parseInt(st.nextToken());
		long target = (long)LCM * GCD;
		for (int i = (int)Math.sqrt(target); i >= 1; --i) {
			if (target % i == 0) {
				int tmp = (int)(target / i);
				int gcd = getGCD(tmp, i);
				if (gcd == GCD && (long)i * tmp / gcd == LCM) {
					System.out.printf("%d %d", i, tmp);
					return;
				}
			}
		}
		br.close();
	}
	static int getGCD(int a, int b) {
		while (b > 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
