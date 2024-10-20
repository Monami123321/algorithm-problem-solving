import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[1001];
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            visited[Integer.parseInt(st.nextToken())] = true;
        }
        int k = Integer.parseInt(br.readLine());
        if (visited[k]) {
            System.out.println(0);
            return;
        }
        int left = k;
        int right = k;
        while (!visited[left - 1]) {
            left--;
        }
        while (!visited[right + 1]) {
            right++;
        }
        System.out.println((k - left + 1) * (right - k + 1) - 1);
        br.close();
    }
}
