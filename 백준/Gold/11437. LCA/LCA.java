import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int parent, id, depth;
        List<Integer> children;
        public Node(int id) {
            this.id = id;
            this.children = new ArrayList<>();
        }
    }
    static int[][] sparseTable;
    static int tableSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] adjList = new ArrayList[n + 1];
        int tmp = 1;
        tableSize = 1;
        while (tmp <= n) {
            tmp <<= 1;
            tableSize++;
        }
        sparseTable = new int[n + 1][tableSize];
        Arrays.fill(sparseTable[1], 1);
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i < n+1; i++) {
            adjList[i] = new ArrayList<>();
            nodes[i] = new Node(i);
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
        visited[1] = true;
        queue.add(1);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            adjList[now].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                queue.add(e);
                visited[e] = true;
                nodes[e].depth = nodes[now].depth + 1;
                nodes[e].parent = now;
                nodes[now].children.add(e);
                sparseTable[e][0] = now;
                for (int i = 1; i < tableSize; i++) {
                    sparseTable[e][i] = sparseTable[sparseTable[e][i - 1]][i - 1];
                }
            });
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            Node a = nodes[Integer.parseInt(st.nextToken())];
            Node b = nodes[Integer.parseInt(st.nextToken())];
            if (a.depth < b.depth) {
                Node temp = a;
                a = b;
                b = temp;
            }
            int diff = a.depth - b.depth;
            int index = 0;
            while (diff > 0) {
                if ((diff & 1 << index) != 0) {
                    a = nodes[sparseTable[a.id][index]];
                    diff ^= 1 << index++;
                } else {
                    index++;
                }
            }
            if (a == b) {
                sb.append(a.id).append("\n");
            } else {
                index = tableSize;
                while (index-- > 0) {
                    if(sparseTable[a.id][index] != sparseTable[b.id][index]) {
                        a = nodes[sparseTable[a.id][index]];
                        b = nodes[sparseTable[b.id][index]];
                    }
                }
                sb.append(a.parent).append("\n");
            }
        }
        System.out.print(sb);



        br.close();
    }
}

