import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int sheepCnt = 0;
    static int wolfCnt = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            if (map[i][0] != '#') {
                bfs(i, 0);
            }
            if (map[i][m - 1] != '#') {
                bfs(i, m - 1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (map[0][i] != '#') {
                bfs(0, i);
            }
            if (map[n - 1][i] != '#') {
                bfs(n - 1, i);
            }
        }
        sheepCnt = 0;
        wolfCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }
        System.out.printf("%d %d", sheepCnt, wolfCnt);


        br.close();
    }

    static void bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});

        int sheep = 0;
        int wolf = 0;

        if (map[startR][startC] == 'v') {
            ++wolf;
        } else if (map[startR][startC] == 'o') {
            ++sheep;
        }
        map[startR][startC] = '#';
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int r = now[0];
            int c = now[1];


            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr > map.length - 1 || nc < 0 || nc > map[0].length - 1 || map[nr][nc] == '#') {
                    continue;
                }
                if (map[nr][nc] == 'v') {
                    ++wolf;
                } else if (map[nr][nc] == 'o') {
                    ++sheep;
                }
                queue.add(new int[]{nr, nc});
                map[nr][nc] = '#';
            }
        }
        if (sheep > wolf) {
            sheepCnt += sheep;
        } else {
            wolfCnt += wolf;
        }
    }
}
