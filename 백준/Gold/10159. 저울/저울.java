import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] dist = new int[N + 1][N + 1];
        int INF = 1 << 29;
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
        }

        for (int m = 1; m < N + 1; m++) {
            for (int s = 1; s < N + 1; s++) {
                for (int e = 1; e < N + 1; e++) {
                    if (dist[s][e] > dist[s][m] + dist[m][e]) {
                        dist[s][e] = dist[s][m] + dist[m][e];
                    }
                }
            }
        }

        int[] cnt = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (dist[i][j] != INF || dist[j][i] != INF) {
                    cnt[i]++;
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            sb.append(N - cnt[i]).append("\n");

        }


        System.out.print(sb);


    }

}
