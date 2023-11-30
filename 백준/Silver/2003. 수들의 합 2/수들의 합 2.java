import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int cnt = 0;

        while (r < n + 1) {

            if (sum < m) {
                sum += arr[r++];

            } else if (sum > m) {
                sum -= arr[l++];
            } else {
                cnt++;
                sum -= arr[l++];
            }

        }

        System.out.println(cnt);


    }
}
