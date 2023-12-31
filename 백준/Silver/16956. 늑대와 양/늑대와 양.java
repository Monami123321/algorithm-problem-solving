import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Sheep {
        int r, c;

        public Sheep(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] map = new char[h][w];
        List<Sheep> sheeps = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'S') {
                    sheeps.add(new Sheep(i, j));
                }
            }
        }

        sheeps.forEach(e -> {
            for (int i = 0; i < 4; i++) {
                int nr = e.r + dr[i];
                int nc = e.c + dc[i];
                if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1 || map[nr][nc] == 'S') {
                    continue;
                }
                if (map[nr][nc] == 'W') {
                    flag = true;
                    return;
                }
                map[nr][nc] = 'D';
            }
        });

        if(flag) {
            System.out.println(0);
            return;
        }
        sb.append(1).append("\n");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);




        br.close();
    }
}
