import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<BigInteger> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			int len = tmp.length();
			int index = 0;

			while (index < len) {
				while (index < len && (tmp.charAt(index) < '0' || tmp.charAt(index) > '9')) {
					index++;
				}
				if (index == len) {
					break;
				}
				int start = index;
				int end = index;
				while (end < len && (tmp.charAt(end) >= '0' && tmp.charAt(end) <= '9')) {
					end++;
				}
				list.add(new BigInteger(tmp.substring(start, end)));
				index = end;
			}
		}
		StringBuilder sb = new StringBuilder();
		list.stream().sorted().forEach(e -> sb.append(e).append("\n"));
		System.out.print(sb);
		br.close();
	}
}
