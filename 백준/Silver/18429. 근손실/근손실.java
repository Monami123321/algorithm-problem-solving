import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        permutation(arr, new boolean[n], 500, 0);
        System.out.println(cnt);


    }

    static void permutation(int[] arr, boolean[] visited, int prev, int pick) {
        if (pick == n) {
            cnt++;
            return;
        }


        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (prev - k + arr[i] < 500) {
                continue;
            }
            visited[i] = true;
            permutation(arr, visited, prev - k + arr[i], pick + 1);
            visited[i] = false;
        }


    }
}
