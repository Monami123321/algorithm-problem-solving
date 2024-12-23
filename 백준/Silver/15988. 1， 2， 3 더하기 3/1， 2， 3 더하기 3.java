import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[1000001];
        final int MOD = 1000000009;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            arr[i] = (arr[i - 3] + arr[i - 2] + arr[i - 1]) % MOD;
        }
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);
        br.close();

    }
}
