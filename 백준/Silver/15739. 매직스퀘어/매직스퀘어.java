import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> list = new ArrayList<>();
        int[][] arr = new int[n][n];
        boolean[] visited = new boolean[n * n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                visited[arr[i][j]] = true;
            }
            list.add(arr[i]);
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println("FALSE");
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = arr[j][i];
            }
            list.add(tmp);
        }
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i][i];
        }
        list.add(tmp);
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[n - 1 - i][i];
        }
        list.add(tmp);
        int val = n * (n * n + 1) >> 1;
        for (int[] e : list) {
            if (!isValid(e, val)) {
                System.out.println("FALSE");
                return;
            }
        }
        System.out.println("TRUE");
        br.close();
    }

    static boolean isValid(int[] arr, int val) {
        return Arrays.stream(arr).sum() == val;
    }
}
