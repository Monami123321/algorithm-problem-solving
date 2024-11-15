import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] adjMatrix;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            if ((cnt & 1) != 0) {
                System.out.println(-1);
                return;
            }
        }
        sb = new StringBuilder();
        dfs(0);
        System.out.print(sb);
        br.close();
    }

    static void dfs(int node) {
        for (int i = 0; i < adjMatrix.length; i++) {
            while (adjMatrix[node][i] > 0) {
                adjMatrix[node][i]--;
                adjMatrix[i][node]--;
                dfs(i);
            }
        }
        sb.append((node + 1) + " ");
    }
}