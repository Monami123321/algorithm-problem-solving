import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());
        int[][] dp = new int[26][arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            dp[arr[i - 1] - 97][i]++;
            for (int j = 0; j < 26; j++) {
                dp[j][i] += dp[j][i - 1];
            }
        }
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int r = st.nextToken().charAt(0) - 97;
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken()) + 1;
            sb.append(dp[r][e] - dp[r][s]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
