import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        arr[1] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cnt = now[0];
            int h = now[1];

            if (h < n && arr[h + 1] > cnt + 1) {
                arr[h + 1] = cnt + 1;
                q.add(new int[]{cnt + 1, h + 1});
            }
            int next = h + (h >> 1);
            if (next <= n && arr[next] > cnt + 1) {
                arr[next] = cnt + 1;
                q.add(new int[]{cnt + 1, next});
            }
        }
        if (arr[n] > k) {
            System.out.println("water");
        } else {
            System.out.println("minigimbob");
        }
        br.close();
    }
}
