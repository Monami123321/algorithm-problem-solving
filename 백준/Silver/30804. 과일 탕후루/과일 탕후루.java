import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 1; i <= 8; i++) {
            for (int j = i + 1; j <= 9; j++) {
                int start = 0;
                int end = 0;
                while (end < n) {
                    while (end < n && (arr[end] == i || arr[end] == j)) {
                        end++;
                    }
                    ans = Math.max(ans, end - start);
                    while (end < n && (arr[end] != i && arr[end] != j)) {
                        end++;
                    }
                    start = end;
                }
            }
        }
        System.out.println(ans);
    }
}
