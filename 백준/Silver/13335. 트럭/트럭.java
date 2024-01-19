import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int index = 0;
        int load = arr[0];

        queue.add(new int[]{arr[index++], 0});
        while (index < n && !queue.isEmpty()) {
            time++;
            if (time - queue.peek()[1] > w) {
                load -= queue.poll()[0];
            }
            if (load + arr[index] > l) {
                continue;
            }
            load += arr[index];
            queue.add(new int[]{arr[index++], time-1});
        }
        while (!queue.isEmpty()) {
            time++;
            if (time - queue.peek()[1] > w) {
                queue.poll();
            }

        }
        System.out.println(time);


        br.close();
    }
}
