import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = 0;
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = start; j < 8; j += 2) {
                if (arr[j] == 'F') {
                    ++cnt;
                }
            }
            start ^= 1;
        }
        System.out.println(cnt);
        br.close();
    }
}
