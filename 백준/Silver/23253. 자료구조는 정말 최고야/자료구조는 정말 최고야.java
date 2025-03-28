import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < size; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (prev < now) {
                    System.out.println("No");
                    return;
                }
                prev = now;
            }
        }
        System.out.println("Yes");
        br.close();
    }
}
