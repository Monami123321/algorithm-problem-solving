import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n][n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] tmp1 = arr[i];
                int[] tmp2 = arr[j];
                dist[j][i] = dist[i][j] = getDist(tmp1[0], tmp1[1], tmp2[0], tmp2[1]);
            }
        }
        int[] selected = new int[n];
        for (int i = 0; i < k; i++) {
            selected[n - 1 - i] = 1;
        }

        int ans = Integer.MAX_VALUE;
        do {
            int caseAns = 0;
            int index = 0;
            int[] tmp = new int[k];
            for (int i = 0; i < n; i++) {
                if (selected[i] != 0) {
                    tmp[index++] = i;
                }
            }

            outer:
            for (int i = 0; i < n; i++) {
                int shelterDist = Integer.MAX_VALUE;
                for (int j = 0; j < k; j++) {
                    if (selected[i] == 1) {
                        continue outer;
                    }
                    int shelter = tmp[j];
                    shelterDist = Math.min(dist[shelter][i], shelterDist);
                }
                caseAns = Math.max(caseAns, shelterDist);
            }
            ans = Math.min(ans, caseAns);
        } while (nextPerm(selected));
        System.out.println(ans);

        br.close();
    }

    static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static boolean nextPerm(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }
        swap(arr, i - 1, j);
        int k = arr.length - 1;
        while (i < k) {
            swap(arr, i++, k--);
        }
        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
