import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		if (isAkaraka(word)) {
			System.out.println("AKARAKA");
		} else {
			System.out.println("IPSELENTI");
		}

		br.close();
	}

	static boolean isAkaraka(String word) {
		int len = word.length();
		if (len == 1) {
			return true;
		}
		if (isPalindrome(word)) {
			int half = (len & 1) == 0 ? len >> 1 : (len >> 1) + 1;
			return isAkaraka(word.substring(0, len >> 1)) && isAkaraka(word.substring(half));
		} else {
			return false;
		}
	}

	static boolean isPalindrome(String word) {
		int index = 0;
		int len = word.length();
		while (index < len >> 1) {
			if (word.charAt(index) != word.charAt(len - 1 - index++)) {
				return false;
			}
		}
		return true;
	}

}