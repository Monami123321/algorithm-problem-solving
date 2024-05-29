import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		Set<Long> set = new HashSet<>();
		Queue<long[]> queue = new LinkedList<>();
		queue.add(new long[] {n, 0L});
		int ans = 0;
		while (!queue.isEmpty()) {
			long[] now = queue.poll();
			long num = now[0];
			long cnt = now[1];

			if (num == 1) {
				ans = (int)cnt;
				break;
			}
			long next = num / 3;

			if (next != 0 && num % 3 == 0 && !set.contains(next)) {
				queue.add(new long[] {next, cnt + 1});
				set.add(next);
			}
			next = num >> 1;

			if (next != 0 && (num & 1) == 0 && !set.contains(next)) {
				queue.add(new long[] {next, cnt + 1});
				set.add(next);
			}
			next = num - 1;
			if (!set.contains(next)) {
				queue.add(new long[] {next, cnt + 1});
				set.add(next);
			}
		}
		System.out.println(ans);
		br.close();
	}
}
