import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        BigInteger c = new BigInteger(st.nextToken());
        System.out.println(getMod(a, b, c).toString());
        br.close();
    }

    static BigInteger getMod(BigInteger b, BigInteger e, BigInteger d) {
        if (e.equals(BigInteger.ONE)) {
            return b.mod(d);
        }
        BigInteger half = getMod(b, e.shiftRight(1), d);
        if (e.and(BigInteger.ONE).equals(BigInteger.ZERO)) {
            return half.multiply(half).mod(d);
        } else {
            return (half.multiply(half).mod(d)).multiply(b.mod(d)).mod(d);
        }
    }
}
