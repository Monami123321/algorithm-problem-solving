import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int val = 667;
        while (cnt < n) {
            if (isValid(val)) {
                cnt++;
            }
            val++;
        }
        System.out.println(val - 1);
        br.close();

    }

    static boolean isValid(int n) {
        while (n >= 666) {
            if (n % 1000 == 666) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
