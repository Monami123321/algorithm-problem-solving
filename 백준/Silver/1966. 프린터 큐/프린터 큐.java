import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int val, index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] order = new int[n];
            int pt = n - 1;
            Queue<Node> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                order[j] = Integer.parseInt(st.nextToken());
                q.add(new Node(order[j], j));
            }
            Arrays.sort(order);
            int cnt = 0;
            while (true) {
                while (q.peek().val < order[pt]) {
                    q.add(q.poll());
                }
                Node node = q.poll();
                cnt++;
                if (node.index == m) {
                    sb.append(cnt).append("\n");
                    break;
                }
                pt--;
            }
        }
        System.out.print(sb);
        br.close();

    }
}
