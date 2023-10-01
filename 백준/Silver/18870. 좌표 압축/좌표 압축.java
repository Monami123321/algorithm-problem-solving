import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		int[] sortedArr = new int[n];
		for (int i = 0; i < sortedArr.length; i++) {
			sortedArr[i] = arr[i];

		}

		Arrays.sort(sortedArr);

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0, index = 0; i < sortedArr.length; i++) {
			if (hashMap.get(sortedArr[i]) == null) {
				hashMap.put(sortedArr[i], index++);
			}

		}

		for (int i = 0; i < arr.length; i++) {
			sb.append(hashMap.get(arr[i])).append(" ");

		}
		System.out.println(sb);

		br.close();
	}

}
