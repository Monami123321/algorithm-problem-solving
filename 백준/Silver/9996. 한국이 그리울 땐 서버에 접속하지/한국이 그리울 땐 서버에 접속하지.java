import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		String pattern = br.readLine();

		String before = pattern.substring(0, pattern.indexOf("*"));
		String after = pattern.substring(pattern.indexOf("*") + 1);

		int beforeLen = before.length();
		int afterLen = after.length();

		outer: for (int i = 0; i < n; i++) {
			String text = br.readLine();

			if (text.length() < pattern.length() - 1) {
				sb.append("NE").append("\n");
				continue outer;
			}

			for (int j = 0; j < beforeLen; j++) {
				if (text.charAt(j) != before.charAt(j)) {
					sb.append("NE").append("\n");
					continue outer;
				}

			}
			for (int j = 0; j < afterLen; j++) {
				if (text.charAt(text.length() - 1 - j) != after.charAt(afterLen - 1 - j)) {
					sb.append("NE").append("\n");
					continue outer;
				}

			}
			sb.append("DA").append("\n");

		}
		System.out.print(sb);

		br.close();

	}

}
