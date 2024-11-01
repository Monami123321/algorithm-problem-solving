import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            String tmp = br.readLine();
            long n = Long.parseLong(tmp);
            long ref = (long) Math.pow(10, tmp.length());
            if (n < (ref >> 1)) {
                sb.append(n * (ref - n - 1)).append("\n");
            } else {
                ref >>= 1;
                sb.append(ref * (ref - 1)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
