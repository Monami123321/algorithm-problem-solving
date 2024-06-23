import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "01", true);
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] ref = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "01", true);
            for (int j = 0; j < m; j++) {
                ref[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 1; i >= 2; --i) {
            for (int j = m - 1; j >= 2; --j) {
                if (map[i][j] != ref[i][j]) {
                    flip(map, i - 2, j - 2);
                    ++ans;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != ref[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans);
        br.close();

    }

    static void flip(int[][] map, int r, int c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[r + i][c + j] ^= 1;
            }
        }
    }
}
