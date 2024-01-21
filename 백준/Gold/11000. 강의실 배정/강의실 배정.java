import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] lecture = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lecture[i][0] = start;
            lecture[i][1] = end;
        }
        Arrays.sort(lecture, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lecture[0][1]);
        for (int i = 1; i < n; i++) {
            if (lecture[i][0] >= pq.peek()) {
                pq.poll();
                pq.add(lecture[i][1]);
            } else {
                pq.add(lecture[i][1]);
            }
        }
        System.out.println(pq.size());
        br.close();
    }

}