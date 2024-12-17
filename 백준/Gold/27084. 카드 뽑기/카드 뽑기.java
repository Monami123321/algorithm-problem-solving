import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long MOD = 1000000007;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        long ans = 1L;
        for (int i = 1; i <= n; i++) {
            if (arr[i] != 0) {
                ans = (ans * (arr[i] + 1)) % MOD;
            }
        }
        System.out.println(ans - 1);
        br.close();
    }
}
