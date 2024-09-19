import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n + 1];
        int[] next = new int[n + 1];
        int[] last = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = br.readLine();
            next[i] = i;
            last[i] = i;
        }

        StringTokenizer st;


        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            next[last[from]] = to;
            last[from] = last[next[last[from]]];
            visited[to] = true;
        }
        int start = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                start = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append(arr[start]);
            start = next[start];
        }
        System.out.print(sb);
        br.close();
    }
}
