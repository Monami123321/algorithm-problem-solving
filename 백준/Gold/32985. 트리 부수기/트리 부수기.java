import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] adjList = new ArrayList[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        cnt[0] = -1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int node = now[0];
            int c = now[1];
            for (int i : adjList[node]) {
                if (cnt[i] == 0) {
                    cnt[i] = c + 1;
                    q.add(new int[]{i, c + 1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 1; i--) {
            if ((n - 1 - cnt[i] & 1) == 0) {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        System.out.print(sb);
        br.close();
    }
}