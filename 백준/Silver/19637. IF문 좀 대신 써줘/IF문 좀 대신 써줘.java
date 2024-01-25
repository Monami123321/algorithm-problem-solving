import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] scores = new int[n];
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            scores[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n - 1;

            while (end >= start) {
                int mid = (start+end)/2;
                if (scores[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (start == n) {
                start--;
            }
            sb.append(names[start]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
