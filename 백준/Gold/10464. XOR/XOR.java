import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(String.format("%d\n", getXor(a - 1) ^ getXor(b)));
        }
        System.out.print(sb);
        br.close();
    }

    static int getXor(int n) {
        if (n % 4 == 1) {
            return 1;
        }
        if (n % 4 == 2) {
            return n + 1;
        }
        if (n % 4 == 3) {
            return 0;
        }
        return n;
    }
}
