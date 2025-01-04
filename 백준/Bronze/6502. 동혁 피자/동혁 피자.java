import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) {
                break;
            }
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if ((r << 1) * (r << 1) >= a * a + b * b) {
                sb.append("Pizza ").append(index++).append(" fits on the table.\n");
            } else {
                sb.append("Pizza ").append(index++).append(" does not fit on the table.\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
