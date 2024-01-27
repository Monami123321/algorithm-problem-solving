import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 20) {
            hanoi(n, 1, 2, 3);
            System.out.println(ans);
            System.out.print(sb);

        } else {
            BigInteger num = new BigInteger("2");
            num = num.pow(n).subtract(new BigInteger("1"));
            System.out.println(num);
        }
        br.close();

    }

    static void hanoi(int n, int from, int tmp, int to) {
        if (n == 1) {
            ans++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, from, to, tmp);
        ans++;
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, tmp, from, to);
    }

}
