import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int index = n - 2;
        int max = arr[n - 1];
        int ans = 0;
        while (index >= 0) {
            int now = arr[index--];
            ans = Math.max(ans, max - now);
            max = Math.max(now, max);
        }
        System.out.println(ans);
        br.close();
    }
}
