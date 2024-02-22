import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ans = 0;
        dfs(n, -1, 0, new int[n]);
        System.out.println(ans);
        br.close();
    }

    static void dfs(int n, int prev, int depth, int[] arr) {
        if (depth == n) {
            ans++;
            return;
        }
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < depth; j++) {
                if (arr[j] == i || depth - j == Math.abs(arr[j] - i)) {
                    continue outer;
                }
            }
            arr[depth] = i;
            dfs(n, i, depth + 1, arr);
        }
    }
}
