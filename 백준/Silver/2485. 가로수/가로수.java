import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n - 1];
        int prev = Integer.parseInt(br.readLine());
        int tmp = Integer.parseInt(br.readLine());
        int d = arr[0] = tmp - prev;
        prev = tmp;
        for (int i = 1; i < n - 1; i++) {
            tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp - prev;
            d = getGcd(d, arr[i]);
            prev = tmp;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += arr[i] / d - 1;
        }
        System.out.println(ans);
        br.close();
    }

    static int getGcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
