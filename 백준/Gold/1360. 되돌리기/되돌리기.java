import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        String s;
        int t;

        public Node(String s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        StringTokenizer st;
        String now = "";
        list.add(new Node(now, 0));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("type")) {
                now += st.nextToken();
                list.add(new Node(now, Integer.parseInt(st.nextToken())));
            } else {
                int tmp = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int ref = Math.max(0, t - tmp - 1);
                for (Node node : list) {
                    if (node.t > ref) {
                        break;
                    }
                    now = node.s;
                }
                list.add(new Node(now, t));
            }
        }
        System.out.print(now);
        br.close();
    }
}
