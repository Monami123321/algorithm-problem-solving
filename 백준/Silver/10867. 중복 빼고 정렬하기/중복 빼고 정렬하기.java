import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken()) + 1000] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2001; i++) {
            if (arr[i]) {
                sb.append(i - 1000).append(" ");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
