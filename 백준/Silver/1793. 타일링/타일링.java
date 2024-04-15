import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BigInteger[] arr = new BigInteger[251];
        arr[0] = new BigInteger("1");
        arr[1] = new BigInteger("1");
        for (int i = 2; i < 251; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2].multiply(BigInteger.valueOf(2)));
        }
        while (true) {
            String tmp = br.readLine();
            if (tmp == null) {
                break;
            }
            int n = Integer.parseInt(tmp);
            sb.append(arr[n]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
