import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n * 26 < k || n > k) {
            System.out.println("!");
            return;
        }
        k -= n;
        int zCnt = k / 25;
        int r = k % 25;
        StringBuilder sb = new StringBuilder();
        int index = r == 0 ? n - zCnt : n - zCnt - 1;
        for (int i = 0; i < index; i++) {
            sb.append('A');
        }
        if (r != 0) {
            sb.append((char) (65 + r));
            index++;
        }
        for (int i = index; i < n; i++) {
            sb.append('Z');
        }
        System.out.print(sb);
        br.close();
    }
}
