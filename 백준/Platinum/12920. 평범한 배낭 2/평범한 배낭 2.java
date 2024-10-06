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
            int c = Integer.parseInt(st.nextToken());

            int index = 1;
            while (c >= index) {
                int weight = w * index;
                int val = v * index;
                for (int j = m; j >= weight; j--) {
                    arr[j] = Math.max(arr[j - weight] + val, arr[j]);
                }
                c -= index;
                index <<= 1;
            }
            if (c == 0) {
                continue;
            }
            w *= c;
            v *= c;
            for (int j = m; j >= w; j--) {
                arr[j] = Math.max(arr[j - w] + v, arr[j]);
            }
        }
        System.out.println(arr[m]);
        br.close();
    }
}
