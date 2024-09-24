import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] accMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr > n - 1 || nc > m - 1) {
                        continue;
                    }
                    accMap[nr][nc] = Math.max(accMap[nr][nc], accMap[i][j] + map[i][j]);
                }
            }
        }
        System.out.print(accMap[n - 1][m - 1] + map[n - 1][m - 1]);
        br.close();
    }
}
