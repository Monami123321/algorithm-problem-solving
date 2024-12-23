import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 10007;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];
        arr[1] = 1;
        arr[2] = 3;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + (arr[i - 2] << 1)) % MOD;
        }
        System.out.println(arr[n]);
        br.close();
    }
}
