import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = k - 1; i < n; i++) {
            sb.append(arr[i]);
        }
        int cnt = n - k + 1;
        if ((cnt & 1) == 0) {
            for (int i = 0; i < k - 1; i++) {
                sb.append(arr[i]);
            }
        } else {
            for (int i = k - 2; i >= 0; i--) {
                sb.append(arr[i]);
            }
        }

        System.out.print(sb);
        br.close();
    }
}
