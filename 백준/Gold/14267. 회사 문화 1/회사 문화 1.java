import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int give, take;
        List<Node> children;

        public Node() {
            this.children = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new Node();
        }
        st.nextToken();
        for (int i = 2; i < n + 1; i++) {
            nodes[Integer.parseInt(st.nextToken())].children.add(nodes[i]);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            nodes[now].take += score;
            nodes[now].give += score;
        }
        dfs(nodes[1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            sb.append(nodes[i].take).append(" ");
        }
        System.out.print(sb);
        br.close();
    }

    static void dfs(Node node) {
        node.children.forEach(e-> {
            e.take += node.give;
            e.give += node.give;
            dfs(e);
        });
    }
}
