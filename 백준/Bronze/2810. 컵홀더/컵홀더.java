import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'S') {
                cnt++;
            } else {
                cnt++;
                i++;
            }
        }
        System.out.println(Math.min(cnt, n));
        br.close();
    }
}
