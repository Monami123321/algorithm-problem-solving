import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Node[] nodes = new Node[(n - 2) * (n - 2)];
        for (int i = 1, index = 0; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int sum = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    sum += map[nr][nc];
                }
                nodes[index++] = new Node(i, j, sum);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.length - 2; i++) {
            for (int j = i + 1; j < nodes.length - 1; j++) {
                for (int k = j + 1; k < nodes.length; k++) {
                    if (isPossible(nodes[i], nodes[j], nodes[k])) {
                        ans = Math.min(ans, nodes[i].cost + nodes[j].cost + nodes[k].cost);
                    }
                }
            }
        }
        System.out.println(ans);
        br.close();
    }

    static boolean isPossible(Node a, Node b, Node c) {
        if (getDist(a.r, a.c, b.r, b.c) < 3) {
            return false;
        }
        if (getDist(a.r, a.c, c.r, c.c) < 3) {
            return false;
        }
        if (getDist(b.r, b.c, c.r, c.c) < 3) {
            return false;
        }
        return true;
    }

    static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
