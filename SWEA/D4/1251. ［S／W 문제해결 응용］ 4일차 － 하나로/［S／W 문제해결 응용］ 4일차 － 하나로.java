import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    static class Edge implements Comparable<Edge> {
        Node nodeA;
        Node nodeB;
        double weight;
 
        public Edge(Node nodeA, Node nodeB, double weight) {
            super();
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Edge o) {
            if (this.weight - o.weight >= 0)
                return 1;
            else
                return -1;
 
        }
 
    }
 
    static class Node {
        int id;
        int r;
        int c;
 
        public Node(int id) {
            super();
            this.id = id;
        }
 
    }
 
    static void combination(int depth, int chosen, boolean[] visited) {
        if (chosen == 2) {
            int a = 0;
            int b = 0;
 
            for (int i = 0, tmp = 0; i < visited.length; i++) {
                if (visited[i] && tmp == 0) {
                    a = i;
                    tmp++;
                } else if (visited[i] && tmp == 1) {
                    b = i;
                }
 
            }
 
            double weight = (Math.pow((nodes[a].r - nodes[b].r), 2) + Math.pow((nodes[a].c - nodes[b].c), 2)) * tax;
 
            edges[edgeIndex++] = new Edge(nodes[a], nodes[b], weight);
 
            return;
        }
 
        if (depth == visited.length) {
 
            return;
        }
 
        visited[depth] = true;
        combination(depth + 1, chosen + 1, visited);
        visited[depth] = false;
        combination(depth + 1, chosen, visited);
 
    }
 
    static int findSet(int x) {
        if (x != parent[x])
            parent[x] = findSet(parent[x]);
        return parent[x];
 
    }
 
    static void union(int x, int y) {
 
        parent[findSet(y)] = findSet(x);
 
    }
 
    static Node[] nodes;
    static Edge[] edges;
    static int edgeIndex;
    static double tax;
    static int[] parent;
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int testCases = scanner.nextInt();
 
        for (int tc = 1; tc <= testCases; tc++) {
            int n = scanner.nextInt();
 
            nodes = new Node[n];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node(i);
 
            }
 
            for (int i = 0; i < n; i++) {
                nodes[i].c = scanner.nextInt();
 
            }
            for (int i = 0; i < n; i++) {
                nodes[i].r = scanner.nextInt();
 
            }
            tax = scanner.nextDouble();
 
            // 각 정점을 연결하는 모든 간선을 구해서 간선 배열 만들기, 가중치에 따라 정렬
            // n개 정점에서 그을 수 있는 간선의 수는 (n-1)+(n-2) ... +1
 
            edges = new Edge[n * (n - 1) / 2]; // 모든 간선 관리 배열
 
            edgeIndex = 0;
 
            combination(0, 0, new boolean[n]); // 모든 간선 초기화 끝
 
            Arrays.sort(edges); // 간선을 가중치 기준으로 오름차순 정렬
 
            parent = new int[n]; // representative
 
            for (int i = 0; i < parent.length; i++) { // make-set
                parent[i] = i;
 
            }
 
            double ans = 0;
            int pick = 0;
            for (int i = 0; i < edges.length; i++) {
                int px = findSet(edges[i].nodeA.id);
                int py = findSet(edges[i].nodeB.id);
 
                if (px != py) {
                    union(px, py);
                    ans += edges[i].weight;
                    pick++;
 
                }
                if (pick == n - 1)
                    break;
            }
 
            System.out.printf("#%d %d\n", tc, Math.round(ans));
 
        }
 
        scanner.close();
    }
 
}