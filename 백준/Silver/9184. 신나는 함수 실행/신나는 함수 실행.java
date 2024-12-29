import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[21][21][21];

    static {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                dp[i][0][j] = dp[i][j][0] = dp[0][i][j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, getVal(a, b, c)));
        }
        System.out.print(sb);
        br.close();
    }

    static int getVal(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return getVal(20, 20, 20);
        }
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            return dp[a][b][c] = getVal(a, b, c - 1) + getVal(a, b - 1, c - 1) - getVal(a, b - 1, c);
        }
        return dp[a][b][c] = getVal(a - 1, b, c) + getVal(a - 1, b - 1, c) + getVal(a - 1, b, c - 1) - getVal(a - 1, b - 1, c - 1);
    }
}
