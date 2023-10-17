import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pQueue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pQueue.offer(Long.parseLong(br.readLine()));

		}

		long ans = 0;

		while (pQueue.size() > 1) {
			long tmp = pQueue.poll() + pQueue.poll();
			ans += tmp;
			pQueue.offer(tmp);
		}
		
		System.out.println(ans);

		br.close();
	}

}
