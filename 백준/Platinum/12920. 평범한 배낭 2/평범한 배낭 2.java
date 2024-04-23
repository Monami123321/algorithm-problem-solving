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
        int[] arr = new int[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int now = 1;
            while (k > now) {
                int weight = w * now;
                int value = v * now;
                for (int j = m; j >= weight; j--) {
                    arr[j] = Math.max(arr[j], arr[j - weight] + value);
                }
                k -= now;
                now <<= 1;
            }
            w *= k;
            v *= k;
            for (int j = m; j >= w; j--) {
                arr[j] = Math.max(arr[j], arr[j - w] + v);
            }
        }
        System.out.println(arr[m]);
        br.close();
    }
}
