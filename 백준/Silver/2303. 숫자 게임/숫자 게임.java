import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[5];
        int max = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int now = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = j+1; k < 4; k++) {
                    for (int l = k+1; l < 5; l++) {
                        now = Math.max(now, (arr[j] + arr[k] + arr[l]) % 10);
                    }
                }
            }
            if (now >= max) {
                ans = i + 1;
                max = now;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
