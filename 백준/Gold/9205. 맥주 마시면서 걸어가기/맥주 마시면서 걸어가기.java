import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean flag;
    static int[][] points;

    static int n;


    static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);

    }

    static void dfs(int r, int c, int beer, boolean[] visited) {
        if (flag) {
            return;
        }

        if (getDist(r, c, points[n + 1][0], points[n + 1][1]) <= beer * 50) {
            flag = true;
            return;
        }
        beer = 20; // 편의점 도착 ㅡ> 맥주 꽉채움

        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                continue;
            }
            int tmp = getDist(r, c, points[i][0], points[i][1]);
            int limit = beer * 50;

            if (tmp > limit) {
                continue;
            }

            //int nextBeer = (limit - tmp) / 50;
            //int nextLeft = (limit - tmp) % 50;
            visited[i] = true;

            dfs(points[i][0], points[i][1], 20, visited);



        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        String SUCCESS = "happy";
        String FAIL = "sad";
        for (int tc = 1; tc <= testCases; tc++) {
            n = Integer.parseInt(br.readLine()); // 편의점 갯수
            flag = false; // 답 나왔는지 확인하는 플래그
            points = new int[n + 2][2]; // 0번 start n+1번 end

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i][0] = x;
                points[i][1] = y;

            }

            dfs(points[0][0], points[0][1], 20, new boolean[n + 2]);

            if (flag) {
                sb.append(SUCCESS).append("\n");
            } else {
                sb.append(FAIL).append("\n");
            }

        }
        System.out.print(sb);
    }
}
