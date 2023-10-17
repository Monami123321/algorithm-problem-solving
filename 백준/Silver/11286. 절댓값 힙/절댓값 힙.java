import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> {
			if (Math.abs(a) == Math.abs(b)) {
				return a - b;
			} else {
				return Math.abs(a) - Math.abs(b);
			}
		});

		for (int i = 0; i < n; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if (cmd == 0) {
				if (pQueue.isEmpty()) {
					sb.append(0).append("\n");

				} else {
					sb.append(pQueue.poll()).append("\n");
				}

			} else {
				pQueue.offer(cmd);
			}

		}
		System.out.print(sb);

		br.close();
	}

}
