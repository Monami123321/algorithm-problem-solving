import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 갯수
            int d = Integer.parseInt(st.nextToken()); // 의존관계 갯수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            List<int[]>[] adjList = new ArrayList[n + 1];
            for (int j = 1; j < n + 1; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                adjList[b].add(new int[]{a, s});
            }

            int[] minEdges = new int[n + 1];
            Arrays.fill(minEdges, Integer.MAX_VALUE);

            minEdges[c] = 0;

            boolean[] visited = new boolean[n + 1];

            while (true) {
                int min = Integer.MAX_VALUE;
                int minIndex = -1;

                for (int j = 1; j < n + 1; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (minEdges[j] < min) {
                        minIndex = j;
                        min = minEdges[j];
                    }

                }
                if (minIndex == -1) {
                    break;
                }
                visited[minIndex] = true;

                for (int[] edge : adjList[minIndex]) {
                    if (visited[edge[0]]) {
                        continue;
                    }
                    minEdges[edge[0]] = minEdges[edge[0]] > min + edge[1] ? min + edge[1] : minEdges[edge[0]];

                }
            }

            int cnt = 0;
            int t = 0;

            for (int j = 1; j < n + 1; j++) {
                if (minEdges[j] == Integer.MAX_VALUE) {
                    continue;
                }
                cnt++;
                t = t < minEdges[j] ? minEdges[j] : t;

            }
            sb.append(cnt).append(" ").append(t).append("\n");


        }
        System.out.print(sb);


    }
}
