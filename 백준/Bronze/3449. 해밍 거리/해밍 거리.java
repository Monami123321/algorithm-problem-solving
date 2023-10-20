import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCases = Integer.parseInt(br.readLine());
		String tmp = "Hamming distance is ";

		for (int i = 0; i < testCases; i++) {
			int[] arr1 = new int[100];
			int[] arr2 = new int[100];
			String tmpIndex = br.readLine();
			int len = tmpIndex.length();
			st = new StringTokenizer(tmpIndex, "01", true);
			int index = 0;
			while (st.hasMoreTokens()) {
				arr1[index++] = Integer.parseInt(st.nextToken());

			}
			st = new StringTokenizer(br.readLine(), "01", true);
			index = 0;
			while (st.hasMoreTokens()) {
				arr2[index++] = Integer.parseInt(st.nextToken());

			}

			int ans = 0;
			for (int j = 0; j < len; j++) {
				if ((arr1[j] ^ arr2[j]) == 1) {
					ans++;
				}

			}
			sb.append(tmp).append(ans).append(".").append("\n");

		}
		System.out.print(sb);

		br.close();
	}

}
