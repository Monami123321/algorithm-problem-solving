import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;
        long[][] dp = new long[n][m];
        long[][] visited = new long[n][m];
        int q = Integer.parseInt(br.readLine());
        long mark = 1;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            visited[a][b] |= mark;
            visited[c][d] |= mark;
            mark <<= 1;
        }
        for (int i = 1; i < n; i++) {
            if (!isValid(visited, i, 0, i - 1, 0)) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (!isValid(visited, 0, i, 0, i - 1)) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (isValid(visited, i, j, i - 1, j)) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (isValid(visited, i, j, i, j - 1)) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
        br.close();
    }

    static boolean isValid(long[][] visited, int a, int b, int c, int d) {
        if (visited[a][b] == 0 || visited[c][d] == 0) {
            return true;
        }
        long l = visited[a][b];
        long r = visited[c][d];
        long check = l | r;
        return (check ^ l ^ r) == 0;
    }
}
