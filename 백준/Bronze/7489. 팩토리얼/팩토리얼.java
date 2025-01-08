import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BigInteger[] arr = new BigInteger[1001];
        arr[1] = BigInteger.ONE;
        for (int i = 2; i < 1001; i++) {
            arr[i] = arr[i - 1].multiply(new BigInteger(Integer.toString(i)));
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        BigInteger five = new BigInteger("5");
        while (tc-- > 0) {
            int index = Integer.parseInt(br.readLine());
            BigInteger val = arr[index];
            String tmp = arr[index].toString();
            int cnt = 1;
            while (val.mod(five).equals(BigInteger.ZERO)) {
                cnt++;
                val = val.divide(five);
            }
            sb.append(tmp.charAt(tmp.length() - cnt)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
