import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int ans = 1;

        while (n > 2) {
            if ((a & 1) == 1 && a + 1 == b) {
                break;
            }

            if ((n & 1) != 0) {
                n = n / 2 + 1;
            } else {
                n /= 2;
            }
            ans++;
            if ((a & 1) == 1) {
                a = a / 2 + 1;
            } else {
                a /= 2;
            }
            if ((b & 1) == 1) {
                b = b / 2 + 1;
            } else {
                b /= 2;
            }
        }
        System.out.println(ans);


        br.close();
    }
}
