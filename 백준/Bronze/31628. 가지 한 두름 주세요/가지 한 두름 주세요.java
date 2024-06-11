import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<>();
        int index = 0;
        int[][] map = new int[10][10];
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                String now = st.nextToken();
                if (hm.get(now) == null) {
                    map[i][j] = index;
                    hm.put(now, index++);
                } else {
                    map[i][j] = hm.get(now);
                }
            }
        }
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (map[i][j - 1] != map[i][j]) {
                    continue outer;
                }
            }
            System.out.println(1);
            return;
        }
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (map[j][i] != map[j - 1][i]) {
                    continue outer;
                }
            }
            System.out.println(1);
            return;
        }
        System.out.println(0);
        br.close();
    }
}
