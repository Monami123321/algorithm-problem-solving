import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] nodes = new int[n][2];
		StringTokenizer st;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nodes[i][0] = start;
			nodes[i][1] = end;
		}
		Arrays.sort(nodes, Comparator.comparingInt(a -> a[0]));
		pq.add(nodes[0][1]);
		for (int i = 1; i < n; i++) {
			if (pq.peek() <= nodes[i][0]) {
				pq.poll();
				pq.add(nodes[i][1]);
			} else {
				pq.add(nodes[i][1]);
			}
		}
		System.out.println(pq.size());
		br.close();
	}
}
