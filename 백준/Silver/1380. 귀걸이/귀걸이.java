import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            String[] arr = new String[n + 1];
            int[] cnt = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = br.readLine();
            }
            for (int i = 0; i < (n << 1) - 1; i++) {
                ++cnt[Integer.parseInt(br.readLine().split(" ")[0])];
            }
            for (int i = 1; i < n+1; i++) {
                if (cnt[i] == 1) {
                    sb.append(tc).append(" ").append(arr[i]).append("\n");
                    break;
                }
            }
            ++tc;
        }
        System.out.println(sb);
        br.close();
    }
}
