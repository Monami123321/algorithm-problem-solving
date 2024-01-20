import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        int[] arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[n] = 0;
        queue.add(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int loc = now[0];
            int cost = now[1];

            if (loc + 1 < arr.length && arr[loc + 1] > cost + 1) {
                queue.add(new int[]{loc + 1, cost + 1});
                arr[loc + 1] = cost + 1;
            }
            if (loc - 1 >= 0 && arr[loc - 1] > cost + 1) {
                queue.add(new int[]{loc - 1, cost + 1});
                arr[loc - 1] = cost + 1;
            }
            if (loc + a < arr.length && arr[loc + a] > cost + 1) {
                queue.add(new int[]{loc + a, cost + 1});
                arr[loc + a] = cost + 1;

            }
            if (loc - a >= 0 && arr[loc - a] > cost + 1) {
                queue.add(new int[]{loc - a, cost + 1});
                arr[loc - a] = cost + 1;
            }
            if (loc + b < arr.length && arr[loc + b] > cost + 1) {
                queue.add(new int[]{loc + b, cost + 1});
                arr[loc + b] = cost + 1;
            }
            if (loc - b >= 0 && arr[loc - b] > cost + 1) {
                queue.add(new int[]{loc - b, cost + 1});
                arr[loc - b] = cost + 1;
            }
            if (loc * a < arr.length && arr[loc * a] > cost + 1) {
                queue.add(new int[]{loc * a, cost + 1});
                arr[loc * a] = cost + 1;
            }
            if (loc * b < arr.length && arr[loc * b] > cost + 1) {
                queue.add(new int[]{loc * b, cost + 1});
                arr[loc * b] = cost + 1;
            }
        }
        System.out.print(arr[m]);


        br.close();
    }
}
