import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int size = 0;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            int index = Arrays.binarySearch(dp, now);
            if (index < 0) {
                index = -index - 1;
            }
            size = Math.max(index + 1, size);
            dp[index] = now;
        }
        System.out.println(size);
        br.close();
    }
}
