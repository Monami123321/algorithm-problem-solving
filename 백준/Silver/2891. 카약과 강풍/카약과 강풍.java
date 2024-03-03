import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            visited[Integer.parseInt(st.nextToken())] = true;
        }
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                if (set.contains(i)) {
                    visited[i] = false;
                    set.remove(i);
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            if (visited[i] && set.contains(i - 1)) {
                visited[i] = false;
                set.remove(i - 1);
            }
            if (visited[i] && set.contains(i + 1)) {
                visited[i] = false;
                set.remove(i + 1);
            }
        }
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
