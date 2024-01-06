import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        while (a > 0) {
            a--;
            sb.append(1);
        }
        System.out.print(sb);
        br.close();
    }
}
