import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Virus {
        int r, c;

        public Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

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

        while (i < k) {
            swap(arr, i++, k--);
        }
        return true;
    }

    static int bfs(int[][] caseMap, List<Virus> virusList) {

        virusList.forEach(e -> queue.add(new int[]{e.r, e.c}));
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || caseMap[nr][nc] != 0)
                    continue;

                queue.add(new int[]{nr, nc});
                caseMap[nr][nc] = 2;

            }

        }

        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (caseMap[i][j] == 0) {
                    res++;
                }

            }

        }

        return res;
    }

    static Queue<int[]> queue;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;

    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        List<int[]> spaceList = new ArrayList<>();
        List<Virus> virusList = new ArrayList<>();
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    spaceList.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                }
            }
        }

        int spaceSize = spaceList.size();

        int[] combination = new int[spaceSize];
        for (int i = 0; i < 3; i++) {
            combination[spaceSize - 1 - i] = 1;
        }

        int ans = 0;

        do {
            int[][] caseMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    caseMap[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < spaceSize; i++) {
                if (combination[i] != 0) {
                    int[] tmp = spaceList.get(i);
                    int r = tmp[0];
                    int c = tmp[1];
                    caseMap[r][c] = 1;
                }

            }
            int res = bfs(caseMap, virusList);
            ans = ans < res ? res : ans;


        } while (nextPermutation(combination));

        System.out.println(ans);


    }
}
