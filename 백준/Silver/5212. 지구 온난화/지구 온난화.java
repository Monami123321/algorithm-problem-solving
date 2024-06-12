import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'X') {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1) {
                            ++cnt;
                            continue;
                        }
                        if (map[nr][nc] == '.') {
                            ++cnt;
                        }
                    }
                    if (cnt > 2) {
                        visited[i][j] = true;
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    map[i][j] = '.';
                }
            }
        }

        int ceil = 0;
        outer:
        while (true) {
            for (int i = 0; i < m; i++) {
                if (map[ceil][i] == 'X') {
                    break outer;
                }
            }
            ++ceil;
        }

        int floor = n - 1;
        outer:
        while (true) {
            for (int i = 0; i < m; i++) {
                if (map[floor][i] == 'X') {
                    break outer;
                }
            }
            --floor;
        }

        int left = 0;
        outer:
        while (true) {
            for (int i = 0; i < n; i++) {
                if (map[i][left] == 'X') {
                    break outer;
                }
            }
            ++left;
        }
        int right = m - 1;
        outer:
        while (true) {
            for (int i = 0; i < n; i++) {
                if (map[i][right] == 'X') {
                    break outer;
                }
            }
            --right;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ceil; i <= floor; i++) {
            for (int j = left; j <= right; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);


        br.close();
    }
}
