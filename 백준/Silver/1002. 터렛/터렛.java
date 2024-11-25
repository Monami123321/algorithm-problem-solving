import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            int dist = (int) (Math.pow(r1 - r2, 2) + Math.pow(c1 - c2, 2));
            if (r1 == r2 && c1 == c2 && d1 == d2) {
                sb.append("-1\n");
            } else if ((d1 + d2) * (d1 + d2) > dist && (d1 - d2) * (d1 - d2) < dist) {
                sb.append("2\n");
            } else if ((d1 + d2) * (d1 + d2) == dist || (d1 - d2) * (d1 - d2) == dist) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.print(sb);

        br.close();
    }

}