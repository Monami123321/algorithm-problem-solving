import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] adjMatrix;
    static int[] visited;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new int[n];
        adjMatrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            visited[i] = -1;
        }
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            if (a == -2) {
                break;
            }
            int b = Integer.parseInt(st.nextToken()) - 1;
            adjMatrix[a][b] = true;
            adjMatrix[b][a] = true;
        }
        for (int i = 0; i < n; i++) {
            if (flag) {
                System.out.println(-1);
                return;
            }
            if (visited[i] == -1) {
                dfs(i, 0);
            }
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                sb1.append(i + 1).append(" ");
            } else {
                sb2.append(i + 1).append(" ");
            }
        }
        sb1.append(-1);
        sb2.append(-1);
        System.out.println(1);
        System.out.println(sb1);
        System.out.println(sb2);

        br.close();
    }

    static void dfs(int node, int mark) {
        if (flag) {
            return;
        }
        visited[node] = mark;
        for (int i = 0; i < n; i++) {
            if (adjMatrix[node][i] || node == i) {
                continue;
            }
            if (visited[i] == mark) {
                flag = true;
                return;
            }
            if (visited[i] == -1) {
                dfs(i, mark ^ 1);
            }
        }
    }
}
