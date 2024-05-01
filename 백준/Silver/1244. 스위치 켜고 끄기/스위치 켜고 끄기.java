import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int index = Integer.parseInt(st.nextToken());
                int now = index;
                while (now <= n) {
                    arr[now] ^= 1;
                    now += index;
                }
            } else {
                int index = Integer.parseInt(st.nextToken());
                int offset = 0;
                while (index + offset <= n && index - offset > 0 && arr[index + offset] == arr[index - offset]) {
                    offset++;
                }
                offset--;
                for (int j = index - offset; j <= index + offset; j++) {
                    arr[j] ^= 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
