import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if ((a + b + c) % 3 != 0) {
            System.out.println(0);
            return;
        }
        int sum = a + b + c;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[sum + 1][sum + 1];
        queue.add(new int[]{a, b, c});
        visited[a][b] = true;
        visited[b][a] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == now[1] && now[1] == now[2]) {
                System.out.println(1);
                return;
            }

            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (now[i] != now[j]) {
                        int l = Math.min(now[i], now[j]);
                        int h = Math.max(now[i], now[j]);
                        h -= l;
                        l <<= 1;
                        if (visited[l][h]) {
                            continue;
                        }
                        queue.add(new int[]{l, h, sum - h - l});
                        visited[l][h] = true;
                        visited[h][l] = true;
                    }
                }
            }

        }
        System.out.println(0);
        br.close();
    }
}
