import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int now = 1;
        int d = 4;
        int ans = 0;

        while (n >= 0) {
            ans++;
            n -= now;
            now += d;
            d += 4;
        }
        System.out.println(ans - 1);
        br.close();
    }
}
