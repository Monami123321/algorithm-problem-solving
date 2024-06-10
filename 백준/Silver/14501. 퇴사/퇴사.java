import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            ans = Math.max(ans, getProfit(i, arr, n));
        }
        System.out.println(ans);
        br.close();
    }

    static int getProfit(int n, int[][] arr, int limit) {
        int index = 0;
        int res = 0;
        int prev = -1;
        while (index < limit) {
            if (((1 << index) & n) != 0) {
                if (prev >= index || arr[index][0] + index > limit) {
                    return 0;
                }
                prev = index + arr[index][0] - 1;
                res += arr[index][1];
            }
            ++index;
        }
        return res;
    }
}
