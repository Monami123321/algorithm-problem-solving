import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            int target = i;

            while (target / 10 != 0) {
                if (target % 10 == d) {
                    cnt++;
                }
                target /= 10;
            }
            if (target % 10 == d) {
                cnt++;
            }
        }
        System.out.println(cnt);


        br.close();
    }
}
