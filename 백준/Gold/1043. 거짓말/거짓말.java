import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[m];
        Set<Integer> set = new HashSet<>();
        Set<Integer> nextSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int person = Integer.parseInt(st.nextToken());
        for (int i = 0; i < person; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer>[] parties = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            parties[i] = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        while (!set.isEmpty()) {
            for (int i = 0; i < m; i++) {
                if (visited[i]) {
                    continue;
                }
                for (int p : parties[i]) {
                    if (set.contains(p)) {
                        visited[i] = true;
                        break;
                    }
                }
                if (visited[i]) {
                    for (int p : parties[i]) {
                        nextSet.add(p);
                    }
                }
            }
            nextSet.removeAll(set);
            set = nextSet;
            nextSet = new HashSet<>();
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
