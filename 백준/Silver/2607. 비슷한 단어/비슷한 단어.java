import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] target = new int[26];
        String tmp = br.readLine();
        int len = tmp.length();
        for (int i = 0; i < len; i++) {
            target[tmp.charAt(i) - 65]++;
        }
        int ans = 0;

        outer:
        for (int i = 0; i < n - 1; i++) {
            String now = br.readLine();
            int nowLen = now.length();
            if (Math.abs(len - nowLen) > 1) {
                continue;
            }
            int[] arr = new int[26];
            for (int j = 0; j < nowLen; j++) {
                arr[now.charAt(j) - 65]++;
            }
            int diffCnt = 0;
            for (int j = 0; j < 26; j++) {
                if (arr[j] != target[j]) {
                    diffCnt++;
                }
            }
            if (len == nowLen) {
                if (diffCnt == 0) {
                    ans++;
                } else if (diffCnt == 2) {
                    for (int j = 0; j < 26; j++) {
                        if (arr[j] != target[j] && Math.abs(arr[j] - target[j]) > 1) {
                            continue outer;
                        }
                    }
                    ans++;
                }
            } else {
                if (diffCnt == 1) {
                    ans++;
                }
            }

        }
        System.out.println(ans);


        br.close();
    }
}
