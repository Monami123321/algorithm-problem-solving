import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean flag = false;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        StringTokenizer st;
        List<Pos> spaces = new ArrayList<>();
        List<Pos> teachers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'X') {
                    spaces.add(new Pos(i, j));
                } else if (map[i][j] == 'T') {
                    teachers.add(new Pos(i, j));
                }
            }
        }

        int size = spaces.size();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    Pos a = spaces.get(i);
                    Pos b = spaces.get(j);
                    Pos c = spaces.get(k);
                    fill(map, a, b, c);
                    if (isPossible(map, teachers)) {
                        System.out.println("YES");
                        return;
                    }
                    reset(map, a, b, c);
                }
            }
        }
        System.out.println("NO");
        br.close();
    }

    static void fill(char[][] map, Pos a, Pos b, Pos c) {
        map[a.r][a.c] = 'O';
        map[b.r][b.c] = 'O';
        map[c.r][c.c] = 'O';
    }

    static void reset(char[][] map, Pos a, Pos b, Pos c) {
        map[a.r][a.c] = 'X';
        map[b.r][b.c] = 'X';
        map[c.r][c.c] = 'X';
    }

    static boolean isPossible(char[][] map, List<Pos> teachers) {
        for (Pos teacher : teachers) {
            int r = teacher.r;
            int c = teacher.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                while (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
                    if (map[nr][nc] == 'S') {
                        return false;
                    }
                    if (map[nr][nc] == 'T' || map[nr][nc] == 'O') {
                        break;
                    }
                    nr += dr[i];
                    nc += dc[i];
                }
            }

        }
        return true;

    }


}
