import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n << 1];
        for (int i = 0; i < n; i++) {
            arr[i + n] = arr[i] = Integer.parseInt(br.readLine());
        }
        int[] visited = new int[3001];
        int cnt = 0;
        int start = 0;
        int end = k - 1;
        for (int i = 0; i < k; i++) {
            if (visited[arr[i]] == 0) {
                cnt++;
            }
            visited[arr[i]]++;
        }
        int ans = cnt;
        if (visited[c] == 0) {
            ans++;
        }

        while (start < n) {
            if (ans == k + 1) {
                break;
            }
            if (visited[arr[start++]]-- == 1) {
                cnt--;
            }

            if (visited[arr[++end]]++ == 0) {
                cnt++;
            }

            if (visited[c] == 0) {
                ans = Math.max(ans, cnt + 1);
            } else {
                ans = Math.max(ans, cnt);
            }
        }
        System.out.println(ans);
        br.close();
    }
}
