import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        char[] tmp = new char[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, getCnt(map[i]));
                for (int k = 0; k < n; k++) {
                    tmp[k] = map[k][j];
                }
                ans = Math.max(ans, getCnt(tmp));
                for (int k = 0; k < 2; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1) {
                        continue;
                    }
                    map[i][j] ^= map[nr][nc];
                    map[nr][nc] ^= map[i][j];
                    map[i][j] ^= map[nr][nc];

                    ans = Math.max(ans, getCnt(map[i]));
                    if (i != nr) {
                        ans = Math.max(ans, getCnt(map[nr]));
                    }
                    for (int l = 0; l < n; l++) {
                        tmp[l] = map[l][j];
                    }
                    ans = Math.max(ans, getCnt(tmp));
                    if (j != nc) {
                        for (int l = 0; l < n; l++) {
                            tmp[l] = map[l][nc];
                        }
                        ans = Math.max(ans, getCnt(tmp));
                    }
                    map[i][j] ^= map[nr][nc];
                    map[nr][nc] ^= map[i][j];
                    map[i][j] ^= map[nr][nc];
                }
            }
        }
        System.out.println(ans);
        br.close();
    }

    static int getCnt(char[] arr) {
        int cnt = 1;
        int res = cnt;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 1;
            }
        }
        return Math.max(res, cnt);
    }

}
