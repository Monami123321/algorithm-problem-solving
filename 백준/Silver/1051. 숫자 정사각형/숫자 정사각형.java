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
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int len = Math.min(n, m);
        int ans = 1;
        outer:
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                for (int k = 0; k < m - i; k++) {
                    if (map[j][k] == map[j + i][k] && map[j][k + i] == map[j + i][k + i] && map[j][k] == map[j + i][k + i]) {
                        ans = (i + 1) * (i + 1);
                        break outer;
                    }
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}
