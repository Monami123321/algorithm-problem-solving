import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        outer:
        while (true) {
            cnt++;
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    arr[i] -= d;
                    if (arr[i] < 0 && i < n - 1) {
                        arr[i + 1] -= -arr[i] * p / 100;
                    }
                    continue outer;
                }
            }
            cnt--;
            break;
        }
        System.out.println(cnt);
        br.close();
    }
}
