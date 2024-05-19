import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] cnt = new int[k + 1];
        int[][] arr = new int[n][2];

        st = new StringTokenizer(br.readLine());
        int now = 0;
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            if (cnt[arr[i][0]]++ == 0) {
                now++;
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        int index = 0;
        long ans = 0;
        while (now < k) {
            if (cnt[arr[index][0]] == 1) {
                index++;
                continue;
            }
            cnt[arr[index][0]]--;
            now++;
            ans += arr[index++][1];
        }
        System.out.println(ans);
        br.close();
    }
}
