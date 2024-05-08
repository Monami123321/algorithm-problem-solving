import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[1001];
		for (int i = 2; i <= (int)Math.sqrt(1001); i++) {
			if (visited[i]) {
				continue;
			}
			if (isPrime(i)) {
				list.add(i);
				int index = i + i;
				while (index <= 1000) {
					visited[index] = true;
					index += i;
				}
			}
		}
		for (int i = (int)Math.sqrt(1001) + 1; i < 1001; i++) {
			if (visited[i]) {
				continue;
			}
			list.add(i);
		}
		int now = 2;
		int cnt = 2;
		StringBuilder sb = new StringBuilder();
		sb.append(len).append("\n").append("1 2 ");
		while (cnt++ < len - 1) {
			sb.append(++now).append(" ");
		}
		for (int tmp : list) {
			if (tmp > now) {
				sb.append(tmp);
				break;
			}
		}
		System.out.print(sb);
		br.close();
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
