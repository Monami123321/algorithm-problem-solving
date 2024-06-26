import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fact(1, n));
        br.close();
    }

    static BigInteger fact(int start, int end) {
        if (end - start < 3) {
            long m = start;
            for (int i = start + 1; i <= end; i++) {
                m *= i;
            }
            return BigInteger.valueOf(m);
        }
        int mid = start + end >> 1;
        return fact(start, mid).multiply(fact(mid + 1, end));
    }
}
