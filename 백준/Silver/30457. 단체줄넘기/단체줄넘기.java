import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = 0;
        int cnt = 0;
        int prev = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != prev) {
                ans++;
                prev = arr[i];
                cnt = 1;
            } else {
                if (cnt < 2) {
                    cnt++;
                    ans++;
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}

