import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n-- > 0) {
            if ((Integer.parseInt(br.readLine()) & 1) != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
