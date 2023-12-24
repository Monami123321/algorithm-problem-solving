import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] sharks = new int[n * n][5];  // {번호,좋아하는학생순서대로4개}
        map = new int[n][n];
        HashMap<Integer, int[]> hashMap = new HashMap<>();

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            sharks[i][0] = Integer.parseInt(st.nextToken());
            sharks[i][1] = Integer.parseInt(st.nextToken());
            sharks[i][2] = Integer.parseInt(st.nextToken());
            sharks[i][3] = Integer.parseInt(st.nextToken());
            sharks[i][4] = Integer.parseInt(st.nextToken());
            hashMap.put(sharks[i][0], sharks[i]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return b[2] - a[2];
            }
            if (a[3] != b[3]) {
                return b[3] - a[3];
            }
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        }); //{r,c,좋아하는상어숫자,빈자리숫자}

        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] != 0) {
                        continue;
                    }
                    int[] now = sharks[i];
                    int cnt = 0;
                    int zeroCnt = 0;

                    for (int l = 0; l < 4; l++) {
                        int nr = j + dr[l];
                        int nc = k + dc[l];
                        if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1) {
                            continue;
                        }
                        for (int m = 1; m <= 4; m++) {
                            if (map[nr][nc] == now[m]) {
                                cnt++;
                                break;
                            } else if (map[nr][nc] == 0) {
                                zeroCnt++;
                                break;
                            }
                        }
                    }
                    pq.add(new int[]{j, k, cnt, zeroCnt});
                }
            }
            int[] selected = pq.poll();
            map[selected[0]][selected[1]] = sharks[i][0];
            pq.clear();
        } // 자리배치 끝


        // 점수계산 시작

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] now = hashMap.get(map[i][j]);
                int cnt = 0;
                for (int k = 0; k < 4; k++) {

                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1) {
                        continue;
                    }

                    for (int l = 1; l <= 4; l++) {
                        if (map[nr][nc] == now[l]) {
                            cnt++;
                            break;
                        }
                    }
                }
                if (cnt == 1) {
                    ans += 1;
                } else if (cnt == 2) {
                    ans += 10;
                } else if (cnt == 3) {
                    ans += 100;
                } else if (cnt == 4) {
                    ans += 1000;
                }

            }

        } // 점수 계산 끝

        System.out.println(ans);


        br.close();
    }
}
