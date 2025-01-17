import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] map;
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
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        br.readLine().chars().forEach(Main::move);
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1) {
                continue;
            }
            map[nr][nc] = '.';
        }
        map[r][c] = '.';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j] == '.' ? '.' : '#');
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void move(int i) {
        switch (i) {
            case 'W':
                bfs(r, c);
                break;
            case 'U':
                r -= 1;
                break;
            case 'D':
                r += 1;
                break;
            case 'L':
                c -= 1;
                break;
            case 'R':
                c += 1;
                break;
        }
    }

    static void bfs(int startR, int startC) {
        char mark = map[startR][startC];
        if (mark == '.') {
            return;
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC});
        map[startR][startC] = '.';
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length || map[nr][nc] != mark) {
                    continue;
                }
                q.add(new int[]{nr, nc});
                map[nr][nc] = '.';
            }
        }
    }
}
