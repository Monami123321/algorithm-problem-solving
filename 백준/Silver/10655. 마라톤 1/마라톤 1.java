import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            total += getDist(points[i], points[i + 1]);
        }

        int ans = total;
        for (int i = 1; i <= n - 2; i++) {
            int now = total;
            now -= getDist(points[i - 1], points[i]) + getDist(points[i], points[i + 1]);
            now += getDist(points[i - 1], points[i + 1]);
            ans = Math.min(now, ans);
        }
        System.out.println(ans);
        br.close();
    }

    static int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
