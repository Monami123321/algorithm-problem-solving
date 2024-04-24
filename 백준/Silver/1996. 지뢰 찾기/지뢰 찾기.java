import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (tmp[j] != '.') {
                    map[i][j + 1] = Integer.MIN_VALUE;
                    int now = tmp[j] - 48;
                    for (int k = 0; k < 8; k++) {
                        int nr = i + dr[k];
                        int nc = j + 1 + dc[k];
                        map[nr][nc] += now;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] < 0) {
                    sb.append("*");
                } else if (map[i][j] < 10) {
                    sb.append(map[i][j]);
                } else {
                    sb.append("M");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
