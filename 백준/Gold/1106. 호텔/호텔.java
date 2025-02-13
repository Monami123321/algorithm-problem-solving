import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[m + 3000];
        final int INF = 1 << 25;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.stream(arr).sorted(Comparator.comparingInt(a -> a[0])).forEach(e -> {
            int w = e[0];
            int v = e[1];
            for (int i = v; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], dp[i - v] + w);
            }
        });
        System.out.println(IntStream.range(m, dp.length).map(e -> dp[e]).min().getAsInt());
        br.close();
    }
}

