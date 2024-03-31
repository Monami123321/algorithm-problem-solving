import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isCheck(br.readLine().toCharArray())) {
                ++cnt;
            }
        }
        System.out.println(cnt);
        br.close();
    }

    static boolean isCheck(char[] arr) {
        boolean[] visited = new boolean[26];
        char prev = arr[0];
        visited[prev - 97] = true;
        char now;
        for (int i = 1; i < arr.length; i++) {
            now = arr[i];
            if (prev != now) {
                if (visited[now - 97]) {
                    return false;
                }
                visited[now - 97] = true;
                prev = now;
            }
        }
        return true;
    }
}
