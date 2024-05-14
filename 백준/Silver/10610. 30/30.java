import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] tmp = br.readLine().toCharArray();
		int[] arr = new int[10];
		int sum = 0;
		for (int i = 0; i < tmp.length; i++) {
			int now = tmp[i] - '0';
			sum += now;
			arr[now]++;
		}
		StringBuilder sb = new StringBuilder();
		if (arr[0] == 0 || sum % 3 != 0) {
			System.out.println(-1);
		} else {
			int index = 9;
			while (index >= 0) {
				if (arr[index] == 0) {
					index--;
				} else {
					sb.append(index);
					arr[index]--;
				}
			}
		}
		System.out.print(sb);
		br.close();
	}
}
