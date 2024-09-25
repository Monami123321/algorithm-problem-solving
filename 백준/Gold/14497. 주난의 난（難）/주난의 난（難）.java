import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Pos> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int startR = Integer.parseInt(st.nextToken()) - 1;
        int startC = Integer.parseInt(st.nextToken()) - 1;
        int goalR = Integer.parseInt(st.nextToken()) - 1;
        int goalC = Integer.parseInt(st.nextToken()) - 1;
        list.add(new Pos(startR, startC));


        char[][] map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        map[startR][startC] = '2';
        int cnt = 0;
        while (!bfs(goalR, goalC, map)) {
            cnt++;
        }
        System.out.println(cnt + 1);
        br.close();
    }

    static boolean bfs(int goalR, int goalC, char[][] map) {
        Queue<Pos> queue = new LinkedList<>(list);
        list.clear();
        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || map[nr][nc] == '2') {
                    continue;
                }
                if (map[nr][nc] == '1') {
                    list.add(new Pos(nr, nc));
                    map[nr][nc] = '2';
                } else if (map[nr][nc] == '#') {
                    return true;
                } else {
                    queue.add(new Pos(nr, nc));
                    map[nr][nc] = '2';
                }
            }
        }
        return false;
    }
}
