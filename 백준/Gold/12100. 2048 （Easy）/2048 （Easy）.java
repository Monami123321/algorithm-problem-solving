import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int ans = 2;
    static int[][] map, orgMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        orgMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                orgMap[i][j] = Integer.parseInt(st.nextToken());
                ans = Math.max(ans, orgMap[i][j]);
            }
        }
        permutation(new int[5], 0);
        System.out.println(ans);

        br.close();
    }

    static void permutation(int[] res, int depth) {
        if (depth == 5) {
            initMap();
            for (int i = 0; i < 5; i++) {

                int dir = res[i];
                if (dir <= 1) {
                    // 상하
                    dir &= 1;
                    for (int j = 0; j < N; j++) {
                        int[] arr = new int[N];
                        for (int k = 0; k < N; k++) {
                            arr[k] = map[k][j];
                        }
                        move(arr, dir);
                        for (int k = 0; k < N; k++) {
                            map[k][j] = arr[k];
                        }
                    }
                } else {
                    // 좌우
                    dir &= 1;
                    for (int j = 0; j < N; j++) {
                        move(map[j], dir);
                    }
                }

            }
            // 최대값
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ans = Math.max(ans, map[j][k]);
                }
            }
            return;

        }

        for (int i = 0; i < 4; i++) {
            res[depth] = i;
            permutation(res, depth + 1);
        }
    }

    static void move(int[] arr, int dir) {
        // 0 2 정방 1 3 역방
        Queue<Integer> queue = new LinkedList<>();
        if (dir == 0) {
            for (int i = 0; i < N; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                queue.add(arr[i]);
            }
        } else {
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] == 0) {
                    continue;
                }
                queue.add(arr[i]);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            Integer next = queue.peek();
            if (next != null && now == next) {
                now <<= 1;
                queue.poll();
            }
            arr[adjustPos(index++, dir)] = now;
        }

        for (int i = index; i < N; i++) {
            arr[adjustPos(i, dir)] = 0;
        }


    }

    static void initMap() {
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = orgMap[i][j];
            }
        }
    }

    static int adjustPos(int a, int dir) {
        if (dir == 0) {
            return a;
        }
        return N - 1 - a;
    }
}
