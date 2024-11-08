import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(new int[]{Integer.parseInt(st.nextToken()), i + 1});
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] tmp = deque.pollFirst();
            sb.append(String.format("%d ", tmp[1]));
            if (deque.isEmpty()) {
                break;
            }
            int t = tmp[0] > 0 ? tmp[0] - 1 : tmp[0];
            if (t < 0) {
                while (t++ < 0) {
                    deque.addFirst(deque.pollLast());
                }
            } else {
                for (int i = 0; i < t; i++) {
                    deque.add(deque.pollFirst());
                }
            }
        }

        System.out.print(sb);
        br.close();
    }
}
