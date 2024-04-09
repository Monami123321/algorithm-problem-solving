import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> hm = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			Integer num = hm.get(now);
			if (num == null) {
				num = 0;
			}
			hm.put(now, num + 1);
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			sb.append(hm.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
		}
		System.out.print(sb);
		br.close();
	}
}
