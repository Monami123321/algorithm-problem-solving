import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[n << 1 | 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int size = Integer.parseInt(st.nextToken()) + i - 1;
            if (memo[size] > i) {
                memo[size] = i;
            }
        }
        for (int i = memo.length - 2; i >= 1; i--) {
            memo[i] = Math.min(memo[i], memo[i + 1]);
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            sb.append(memo[Integer.parseInt(st.nextToken())]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
