import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
			while (true) {
				String tmp = br.readLine();
				if (tmp.equals("what does the fox say?")) {
					break;
				}
				list.removeIf(e -> e.equals(tmp.split(" ")[2]));
			}
			sb.append(String.join(" ", list)).append("\n");
            list.clear();
		}
		System.out.print(sb);
		br.close();
	}
}
