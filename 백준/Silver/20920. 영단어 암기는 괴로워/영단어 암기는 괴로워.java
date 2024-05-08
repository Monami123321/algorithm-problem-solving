import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			if (tmp.length() < limit) {
				continue;
			}
			map.merge(tmp, 1, Integer::sum);
		}
		StringBuilder sb = new StringBuilder();
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.stream().sorted((a,b) -> {
			if (a.getValue().intValue() != b.getValue()) {
				return b.getValue() - a.getValue();
			}
			int lenA = a.getKey().length();
			int lenB = b.getKey().length();
			if (lenA != lenB) {
				return lenB - lenA;
			}
			return a.getKey().compareTo(b.getKey());
		}).forEach(e-> {
			sb.append(e.getKey()).append("\n");
		});
		System.out.print(sb);



		br.close();
	}
}
