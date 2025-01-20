import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, minSum;
    static int[] ref = new int[4];
    static List<Integer> ansList = new ArrayList<>();
    static String ansStr = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        minSum = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ref[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arr = new int[n][5];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(arr, new boolean[n], 0, 0);

        if (minSum == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(minSum).append("\n");
            for (int c : ansList) {
                sb.append(c).append(" ");
            }
            System.out.print(sb);
        }


        br.close();
    }

    static void comb(int[][] arr, boolean[] visited, int depth, int sum) {
        if (sum > minSum) {
            return;
        }
        if (depth == n) {
            int p = 0;
            int f = 0;
            int s = 0;
            int v = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    p += arr[i][0];
                    f += arr[i][1];
                    s += arr[i][2];
                    v += arr[i][3];
                    sb.append(i + 1);
                }
            }
            if (p < ref[0] || f < ref[1] || s < ref[2] || v < ref[3]) {
                return;
            }
            if (sum == minSum) {
                if (ansStr.compareTo(sb.toString()) < 1) {
                    return;
                }
            }
            minSum = sum;
            ansList.clear();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    ansList.add(i + 1);
                }
            }
            ansStr = sb.toString();
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, sum + arr[depth][4]);
        visited[depth] = false;
        comb(arr, visited, depth + 1, sum);
    }
}
