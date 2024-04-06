import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int me = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int ans = 0;
        while (me <= pq.peek()) {
            pq.add(pq.poll() - 1);
            ++me;
            ++ans;
        }
        System.out.println(ans);
        br.close();
    }
}
