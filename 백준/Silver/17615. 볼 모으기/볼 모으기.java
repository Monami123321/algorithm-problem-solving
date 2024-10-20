import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int start = 0;
        int end = n - 1;
        while (start < n && arr[start] == 'R') {
            start++;
        }
        while (end >= 0 && arr[end] == 'B') {
            end--;
        }
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == 'R') {
                cnt++;
            }
        }
        int ans = Math.min(cnt, end - start + 1 - cnt);
        start = 0;
        end = n - 1;
        while (start < n && arr[start] == 'B') {
            start++;
        }
        while (end >= 0 && arr[end] == 'R') {
            end--;
        }
        cnt = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == 'B') {
                cnt++;
            }
        }
        ans = Math.min(ans, Math.min(cnt, end - start + 1 - cnt));
        System.out.println(ans);
        br.close();
    }
}

