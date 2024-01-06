import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long lcm(long a, long b) {
        long multiple = a * b;
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return multiple / a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            sb.append(lcm(a, b)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
