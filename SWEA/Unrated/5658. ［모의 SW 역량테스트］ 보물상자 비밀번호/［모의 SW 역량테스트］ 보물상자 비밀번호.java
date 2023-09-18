
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	static long HexaToDecimal(String HexaString) {
		return HexaToDecimal(HexaString.toCharArray());

	}

	static long HexaToDecimal(char[] HexaNum) {
		long res = 0L;
		for (int i = 0; i < HexaNum.length; i++) {
			long tmp;
			if (HexaNum[i] - 48 > 9) {
				tmp = HexaNum[i] - 'A' + 10;
			} else {
				tmp = HexaNum[i] - 48;
			}
			res += (tmp);
			res *= 16;

		}
		res /= 16;
		return res;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			scanner.nextLine();

			String box = scanner.next();

			char[] boxNum = box.toCharArray();

			char[] tmp = new char[n / 4];
			PriorityQueue<Long> passwords = new PriorityQueue<>(Collections.reverseOrder());
			for (int rotate = 0; rotate < n/4; rotate++) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < n / 4; j++) {
						tmp[j] = boxNum[((n - rotate) % n + j + (i * (n / 4))) % n];

					}
				Long check = (Long)HexaToDecimal(tmp);
				if (passwords.contains( check))
					continue;

				passwords.add(check);


				}

			}
//			int asd = passwords.size();
//			for (int i = 0; i < asd; i++) {
//				System.out.println(passwords.poll());	
//			}
			
			//System.out.println(passwords.size());
			for (int i = 1; i < k; i++) {
				passwords.poll();
			}

			System.out.printf("#%d %d\n", tc, passwords.poll());

		}

		scanner.close();
	}

}
