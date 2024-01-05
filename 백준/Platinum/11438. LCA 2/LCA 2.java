import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int depth, id;
        Node parent;
        List<Node> child;

        public Node(int id) {
            this.id = id;
            this.child = new ArrayList<>();
        }
    }

    static int[][] sparseTable;
    static List<Integer>[] adjList;
    static Node[] nodes;
    static int tableSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new Node(i);
            adjList[i] = new ArrayList<>();
        }
        tableSize = 0;
        for (int i = 17; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                tableSize = i;
                break;
            }
        }
        sparseTable = new int[n + 1][tableSize + 1];
        Arrays.fill(sparseTable[1], 1);
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        queue.add(nodes[1]);
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            adjList[now.id].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                visited[e] = true;
                queue.add(nodes[e]);
                nodes[e].parent = now;
                nodes[e].depth = now.depth + 1;
                now.child.add(nodes[e]);
                sparseTable[nodes[e].id][0] = now.id;
                for (int i = 1; i < tableSize + 1; i++) {
                    sparseTable[nodes[e].id][i] = sparseTable[sparseTable[nodes[e].id][i - 1]][i - 1];
                }
            });
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Node a = nodes[Integer.parseInt(st.nextToken())];
            Node b = nodes[Integer.parseInt(st.nextToken())];
            if (a.depth > b.depth) {
                Node tmp = a;
                a = b;
                b = tmp;
            }
            int diff = b.depth - a.depth;
            for (int j = tableSize; j >= 0; j--) {
                if ((diff & (1 << j)) != 0) {
                    b = nodes[sparseTable[b.id][j]];
                }
            }

            if (a.id == b.id) {
                sb.append(a.id).append("\n");
                continue;
            }


            for (int j = tableSize; j >= 0; j--) {
                if (sparseTable[a.id][j] == sparseTable[b.id][j]) {
                    continue;
                }
                a = nodes[sparseTable[a.id][j]];
                b = nodes[sparseTable[b.id][j]];
            }
            sb.append(a.parent.id).append("\n");

        }
        System.out.print(sb);


        br.close();
    }
}
