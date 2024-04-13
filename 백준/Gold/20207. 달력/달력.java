import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] plans = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            plans[i][0] = Integer.parseInt(st.nextToken());
            plans[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(plans,(a,b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int[] arr = new int[367];
        int[][] map = new int[n + 1][366];
        for (int i = 0; i < n; i++) {
            int start = plans[i][0];
            int end = plans[i][1];
            int index = 1;
            while (map[index][start] != 0) {
                index++;
            }
            for (int j = start; j <= end; j++) {
                map[index][j] = 1;
                arr[j] = Math.max(arr[j], index);
            }
        }
        int ans = 0;
        for (int i = 1; i < 366; i++) {
            if (arr[i] == 0) {
                continue;
            }
            int height = arr[i];
            int left = i;
            while (arr[i + 1] != 0) {
                ++i;
                height = Math.max(height, arr[i]);
            }
            ans += (i - left + 1) * height;
        }
        System.out.println(ans);
        br.close();
    }


}