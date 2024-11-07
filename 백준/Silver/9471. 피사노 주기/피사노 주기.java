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
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            sb.append(String.format("%d %d\n", i, getCycle(Integer.parseInt(st.nextToken()))));
        }
        System.out.print(sb);
        br.close();
    }

    static int getCycle(int m) {
        int a = 0;
        int b = 1;
        int cnt = 0;
        while (true) {
            cnt++;
            a = (a + b) % m;
            a ^= b;
            b ^= a;
            a ^= b;
            if (a == 0 && b == 1) {
                break;
            }
        }
        return cnt;
    }
}
