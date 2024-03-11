import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; tc++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            if (n > 32) {
                sb.append(0).append("\n");
                continue;
            }
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
            }
            int len = arr.length;
            int ans = Integer.MAX_VALUE;
            outer:for (int i = 0; i < len - 2; i++) {
                for (int j = i+1; j < len-1; j++) {
                    for (int k = j + 1; k < len; k++) {
                        int sum = 0;
                        for (int l = 0; l < 4; l++) {
                            if (arr[i].charAt(l) != arr[j].charAt(l)) {
                                sum++;
                            }
                            if (arr[j].charAt(l) != arr[k].charAt(l)) {
                                sum++;
                            }
                            if (arr[i].charAt(l) != arr[k].charAt(l)) {
                                sum++;
                            }
                        }
                        ans = Math.min(ans, sum);
                        if (ans == 0) {
                            break outer;
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }


        System.out.print(sb);
        br.close();
    }
}
