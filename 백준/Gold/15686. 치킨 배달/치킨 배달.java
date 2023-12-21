import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M, ans;
    static List<int[]> homes, stores;


    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

    }

    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i])
            i--;
        if (i == 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j])
            j--;
        swap(arr, i - 1, j);

        int k = arr.length - 1;
        while (k > i) {
            swap(arr, k--, i++);
        }
        return true;

    }

    static int getChickenDist(int[] combination, int[] home, int[] dist) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < combination.length; i++) {
            if(combination[i] == 0) {
                continue;
            }

            if(res > dist[i]) {
                res = dist[i];
            }
        }
        return res;
    }

    static int getManhattan(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }

    static int bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{startR, startC});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            if (map[r][c] == 2) {
                return Math.abs(startR - r) + Math.abs(startC - c);
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1 || visited[nr][nc]) {
                    continue;
                }
                queue.add(new int[]{nr, nc});
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ans = Integer.MAX_VALUE;
        homes = new ArrayList<>();
        stores = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    stores.add(new int[]{i, j});
                }
            }
        }

        int homeSize = homes.size();
        int storeSize = stores.size();

        int[][] chickenDist = new int[homeSize][storeSize];

        for (int i = 0; i < homeSize; i++) {
            for (int j = 0; j < storeSize; j++) {
                chickenDist[i][j] = getManhattan(homes.get(i), stores.get(j));
            }
        }


        int[] combination = new int[stores.size()];
        for (int i = 0; i < M; i++) {
            combination[stores.size() - 1 - i] = 1;
        }

        do {
            int caseDist = 0;

            for (int i = 0; i < homeSize; i++) {
                caseDist += getChickenDist(combination,homes.get(i),chickenDist[i]);
            }

            ans = Math.min(caseDist, ans);
        } while (nextPermutation(combination));

        System.out.println(ans);

    }
}
