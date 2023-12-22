import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int reqT = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());
            pq.add(new int[]{priority, id, reqT});
        }

        while (t > 0 && !pq.isEmpty()) {
            int[] now = pq.poll();
            sb.append(now[1]).append("\n");
            if (now[2] > 1) {
                now[0] -= 1;
                now[2] -= 1;
                pq.add(now);
            }
            t--;
        }

        System.out.print(sb);


    }
}
