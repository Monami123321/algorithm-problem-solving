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
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int sum = arr[i];
                max = Math.max(max, sum);
                for (int j = i + 1; j < n; j++) {
                    sum += arr[j];
                    max = Math.max(max, sum);
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}

