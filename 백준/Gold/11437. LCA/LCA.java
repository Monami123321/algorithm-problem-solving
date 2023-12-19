import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        Node parent;
        List<Node> child;
        int depth, id;

        public Node(int id) {
            this.id = id;
            this.child = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new Node(i);

        }
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            adjList[now].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                queue.add(e);
                visited[e] = true;
                nodes[e].parent = nodes[now];
                nodes[e].depth = nodes[now].depth + 1;
                nodes[now].child.add(nodes[e]);
                return;
            });
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Node a = nodes[Integer.parseInt(st.nextToken())];
            Node b = nodes[Integer.parseInt(st.nextToken())];

            if (a.depth > b.depth) {
                while (a.depth > b.depth) {
                    a = a.parent;
                }
            } else if (b.depth > a.depth) {
                while (b.depth > a.depth) {
                    b = b.parent;
                }
            }

            if (a == b) {
                sb.append(a.id).append("\n");
                continue;
            } else {
                while (a.parent != b.parent) {
                    a = a.parent;
                    b = b.parent;
                }
                sb.append(a.parent.id).append("\n");
            }
        }
        System.out.print(sb);


    }
}
