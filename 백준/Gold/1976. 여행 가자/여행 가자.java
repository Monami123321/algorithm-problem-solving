import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int targetNum = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];

        StringTokenizer st;

        int INF = 1 << 29;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 0) {
                    dist[i][j] = INF;
                } else {
                    dist[i][j] = a;
                }


            }
            dist[i][i] = 0;

        }
        st = new StringTokenizer(br.readLine());
        int[] target = new int[targetNum];
        for (int i = 0; i < targetNum; i++) {
            target[i] = Integer.parseInt(st.nextToken());

        }

        for (int m = 1; m < n + 1; m++) {
            for (int s = 1; s < n + 1; s++) {
                for (int e = 1; e < n + 1; e++) {
                    if (dist[s][e] > dist[s][m] + dist[m][e]) {
                        dist[s][e] = dist[s][m] + dist[m][e];
                    }
                }
            }

        }

        boolean flag = true;
        for (int i = 0; i < target.length - 1; i++) {
            if (dist[target[i]][target[i + 1]] == INF) {
                flag = false;
                break;
            }

        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}
