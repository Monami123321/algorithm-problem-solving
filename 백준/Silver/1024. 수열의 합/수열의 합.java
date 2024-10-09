import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = l; i <= 100; i++) {
            int start = (i * (i - 1)) >> 1;
            if (start > n) {
                break;
            }
            if ((n - start) % i == 0) {
                int ans = (n - start) / i;
                for (int j = ans; j < ans + i; j++) {
                    sb.append(j).append(" ");
                }
                System.out.print(sb);
                return;
            }
        }
        System.out.println(-1);
        br.close();
    }
}
