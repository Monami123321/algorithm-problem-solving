import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            int globalMax = arr[0];
            for (int i = 1; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                arr[i] = Math.max(arr[i - 1] + arr[i], arr[i]);
                globalMax = Math.max(globalMax, arr[i]);
            }
            sb.append(globalMax).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
