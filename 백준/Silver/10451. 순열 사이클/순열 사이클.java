import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[n + 1];
            int cnt = 0;
            for (int i = 1; i < n + 1; i++) {
                if (visited[i]) {
                    continue;
                }
                ++cnt;
                int now = i;
                while (!visited[now]) {
                    visited[now] = true;
                    now = arr[now];
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

}
