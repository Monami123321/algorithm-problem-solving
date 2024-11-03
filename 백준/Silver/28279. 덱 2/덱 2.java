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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (cmd == 2) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (cmd == 3) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            } else if (cmd == 4) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
            } else if (cmd == 5) {
                sb.append(deque.size()).append("\n");
            } else if (cmd == 6) {
                if (deque.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (cmd == 7) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.getFirst()).append("\n");
                }
            } else {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.getLast()).append("\n");
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}
