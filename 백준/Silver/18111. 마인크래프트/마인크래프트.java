import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        int time = Integer.MAX_VALUE;
        int height = -1;

        for (int h = min; h <= max; h++) {
            int cnt = 0;
            int limit = block;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > h) {
                        cnt += (map[i][j] - h) << 1;
                        limit += map[i][j] - h;
                    } else {
                        cnt += h - map[i][j];
                        limit -= h - map[i][j];
                    }
                }
            }
            if (limit >= 0) {
                if (time >= cnt) {
                    time = cnt;
                    height = h;
                }
            }
        }
        System.out.printf("%d %d", time, height);
        br.close();
    }
}

