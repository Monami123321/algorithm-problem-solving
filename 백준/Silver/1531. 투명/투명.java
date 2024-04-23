import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[101][101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            arr[r1][c1]++;
            if (c2 < 100) {
                arr[r1][c2 + 1]--;
            }
            if (r2 < 100) {
                arr[r2 + 1][c1]--;
            }
            if (r2 < 100 && c2 < 100) {
                arr[r2 + 1][c2 + 1]++;
            }
        }
        for (int i = 1; i < 101; i++) {
            for (int j = 2; j < 101; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
        for (int i = 1; i < 101; i++) {
            for (int j = 2; j < 101; j++) {
                arr[j][i] += arr[j - 1][i];
            }
        }
        int ans = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (arr[i][j] > m) {
                    ++ans;
                }
            }
        }
        System.out.println(ans);
        br.close();
    }

}

