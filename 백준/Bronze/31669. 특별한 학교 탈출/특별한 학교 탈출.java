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
        outer:for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i] == 'O') {
                    continue outer;
                }
            }
            System.out.println(i + 1);
            return;
        }
        System.out.print("ESCAPE FAILED");
        br.close();
    }
}
