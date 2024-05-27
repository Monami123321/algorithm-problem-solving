import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger("1");
		for (int i = 0; i < n; i++) {
			a = a.multiply(new BigInteger(st.nextToken()));
		}
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		BigInteger b = new BigInteger("1");
		for (int i = 0; i < n; i++) {
			b = b.multiply(new BigInteger(st.nextToken()));
		}
		String ans = a.gcd(b).toString();
		if (ans.length() > 9) {
			ans = ans.substring(ans.length() - 9);
		}
		System.out.println(ans);
		br.close();
	}
}
