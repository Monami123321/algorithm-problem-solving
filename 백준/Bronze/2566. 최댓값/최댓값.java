import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = -1;
        int r = -1;
        int c = -1;

        for (int i = 1; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val > max) {
                    r = i;
                    c = j;
                    max = val;
                }

            }
        }

        System.out.println(max);
        System.out.printf("%d %d", r, c);


    }
}
