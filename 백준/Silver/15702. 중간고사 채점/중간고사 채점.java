import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int s = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int score = 0;
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("O")) {
                    score += arr[j];
                }
            }
            if (max < score) {
                s = student;
                max = score;
            } else if (max == score) {
                if (s > student) {
                    s = student;
                }
            }
        }
        System.out.printf("%d %d", s, max);
        br.close();
    }
}
