import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            long sum = 0;
            long ans = Long.MIN_VALUE >> 5;
            for (int i = 0; i < n; i++) {
                sum += Long.parseLong(br.readLine());
                ans = Math.max(ans, sum);
                sum = Math.max(sum, 0);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
