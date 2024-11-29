import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq2.add(pq.poll());
        for (int i = 1; i < n; i++) {
            int[] now = pq.poll();
            if (now[0] >= pq2.peek()[1]) {
                pq2.poll();
                pq2.add(now);
            } else {
                pq2.add(now);
            }
        }
        System.out.println(pq2.size());
        br.close();
    }
}
