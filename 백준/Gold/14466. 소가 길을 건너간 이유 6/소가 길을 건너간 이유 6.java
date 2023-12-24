import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        List<Node> adjList;
        int grass;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
            this.adjList = new ArrayList<>();
        }
    }

    static class Cow {
        int r, c;

        public Cow(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        Node[][] map = new Node[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = new Node(i, j);
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int l = 0; l < 4; l++) {
                    int nr = i + dr[l];
                    int nc = j + dc[l];
                    if (nr < 1 || nr > n || nc < 1 || nc > n) {
                        continue;
                    }
                    map[i][j].adjList.add(map[nr][nc]);
                }
            }
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            map[r1][c1].adjList.remove(map[r2][c2]);
            map[r2][c2].adjList.remove(map[r1][c1]);
        }
        Cow[] cows = new Cow[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int cowR = Integer.parseInt(st.nextToken());
            int cowC = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(cowR, cowC);
        }

        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<Node> queue = new LinkedList<>();
        int grassNum = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (visited[i][j]) {
                    continue;
                }
                grassNum++;
                queue.add(map[i][j]);
                while (!queue.isEmpty()) {
                    Node now = queue.poll();
                    now.grass = grassNum;

                    now.adjList.forEach(node -> {
                        if (visited[node.r][node.c]) {
                            return;
                        }
                        visited[node.r][node.c] = true;
                        queue.add(map[node.r][node.c]);
                    });

                }
            }
        }

        int ans = 0;
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {
                int r1 = cows[i].r;
                int c1 = cows[i].c;
                int r2 = cows[j].r;
                int c2 = cows[j].c;

                if (map[r1][c1].grass != map[r2][c2].grass) {
                    ans++;
                }
            }
        }
        System.out.println(ans);


        br.close();
    }
}
