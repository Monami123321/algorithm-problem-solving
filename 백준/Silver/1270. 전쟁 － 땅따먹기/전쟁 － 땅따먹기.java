import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            long[] arr = new long[tmp];
            long major = 0;
            int cnt = 0;
            for (int j = 0; j < tmp; j++) {
                arr[j] = Long.parseLong(st.nextToken());
                if (cnt == 0) {
                    major = arr[j];
                }
                cnt += arr[j] == major ? 1 : -1;
            }
            cnt = 0;
            for (int j = 0; j < tmp; j++) {
                if (arr[j] == major) {
                    cnt++;
                }
            }
            if (cnt > (tmp >> 1)) {
                sb.append(major).append("\n");
            } else {
                sb.append("SYJKGW\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
