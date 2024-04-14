import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int id, population;
        List<Node> adjList;

        public Node(int id, int population) {
            this.id = id;
            this.population = population;
            this.adjList = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                nodes[i].adjList.add(nodes[Integer.parseInt(st.nextToken())]);
            }
        }
        boolean[] caseCheck = new boolean[(1 << n)];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < (1 << n) - 1; i++) {
            if (caseCheck[i ^ (n - 1)]) {
                continue;
            }
            List<Node> list1 = new ArrayList<>();
            List<Node> list2 = new ArrayList<>();
            boolean[] visited1 = new boolean[n + 1];
            boolean[] visited2 = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    list1.add(nodes[j + 1]);
                    visited2[j + 1] = true;
                } else {
                    list2.add(nodes[j + 1]);
                    visited1[j + 1] = true;
                }
            }
            if (!bfs(list1, visited1)) {
                continue;
            }
            if (!bfs(list2, visited2)) {
                continue;
            }
            int score1 = 0;
            int score2 = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    score1 += nodes[j + 1].population;
                } else {
                    score2 += nodes[j + 1].population;
                }
            }
            ans = Math.min(ans, Math.abs(score1 - score2));
            caseCheck[i] = true;
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);

        }
        br.close();
    }

    static boolean bfs(List<Node> list, boolean[] visited) {
        Map<Integer, Node> hm = new HashMap<>();
        list.forEach(e -> {
            hm.put(e.id, e);
        });
        Node start = list.get(0);
        visited[start.id] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start.id);

        while (!queue.isEmpty()) {
            Node now = hm.get(queue.poll());
            now.adjList.forEach(e -> {
                if (visited[e.id]) {
                    return;
                }
                if (hm.get(e.id) != null) {
                    queue.add(e.id);
                    visited[e.id] = true;
                }
            });
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
