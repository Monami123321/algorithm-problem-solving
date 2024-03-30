import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] map = new char[h][];
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int[][] ansMap = new int[h][w];
        for (int i = 0; i < h; i++) {
            outer:
            for (int j = 0; j < w; j++) {
                int cnt = 0;
                for (int k = j; k >= 0; k--) {
                    if (map[i][k] != 'c') {
                        cnt++;
                    } else {
                        ansMap[i][j] = cnt;
                        continue outer;
                    }
                }
                ansMap[i][j] = -1;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(ansMap[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);


        br.close();
    }

}
