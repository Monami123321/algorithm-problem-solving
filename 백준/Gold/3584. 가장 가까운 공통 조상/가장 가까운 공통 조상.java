import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int id, depth;
        Node parent;
        List<Node> child;

        public Node(int id) {
            this.id = id;
            this.child = new ArrayList<>();
        }
    }

    static int[][] sparseTable;

    static void dfs(Node node, int depth) {
        if (node == null) {
            return;
        }
        node.depth = depth;
        for (int i = 1; i < sparseTable[0].length; i++) {
            sparseTable[node.id][i] = sparseTable[sparseTable[node.id][i - 1]][i - 1];
        }

        node.child.forEach(n -> {
            dfs(n, depth + 1);

        });
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCases; tc++) {
            int n = Integer.parseInt(br.readLine());
            int tableSize = 0;
            for (int i = 14; i >= 0; i--) {
                if ((n & (1 << i)) != 0) {
                    tableSize = i + 1;
                    break;
                }

            }
            sparseTable = new int[n + 1][tableSize];

            Node[] nodes = new Node[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a].child.add(nodes[b]);
                nodes[b].parent = nodes[a];
                sparseTable[b][0] = a;
            }
            Node root = null;
            for (int i = 1; i < n + 1; i++) {
                if (nodes[i].parent == null) {
                    root = nodes[i];
                    break;
                }
            }
            for (int i = 0; i < tableSize; i++) {
                sparseTable[root.id][i] = root.id;
            }
            dfs(root, 0);
            st = new StringTokenizer(br.readLine());
            Node a = nodes[Integer.parseInt(st.nextToken())];
            Node b = nodes[Integer.parseInt(st.nextToken())];

            if (a.depth < b.depth) {
                Node tmp = a;
                a = b;
                b = tmp;
            }

            int diff = a.depth - b.depth;

            for (int i = 14; i >= 0; i--) {
                if ((diff & (1 << i)) != 0) {
                    a = nodes[sparseTable[a.id][i]];
                }
            }
            if (a == b) {
                sb.append(a.id).append("\n");
                continue;
            }

            for (int i = sparseTable[0].length - 1; i >= 0; i--) {
                if (sparseTable[a.id][i] != sparseTable[b.id][i]) {
                    a = nodes[sparseTable[a.id][i]];
                    b = nodes[sparseTable[b.id][i]];
                }

            }
            sb.append(a.parent.id).append("\n");


        }
        System.out.print(sb);


        br.close();
    }
}
