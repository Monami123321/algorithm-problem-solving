import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        int score = 0;
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int now = pq.poll();
            if (now <= k) {
                continue;
            }
            score = (score >> 1) + now;
            sb.append(score).append("\n");
            pq.add(now - m);
            cnt++;
        }
        System.out.println(cnt);
        System.out.print(sb);
        br.close();
    }
}
