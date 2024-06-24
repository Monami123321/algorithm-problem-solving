import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sqrt = (int) Math.sqrt(n);
        int rem = (n - sqrt * sqrt);
        int m;
        if (rem > sqrt) {
            m = ++sqrt;
        } else if (rem == 0) {
            m = sqrt;
        } else {
            m = sqrt + 1;
        }
        int ans = (sqrt - 1 << 1) + (m - 1 << 1);
        System.out.println(Math.max(ans, 4));
        br.close();
    }
}
