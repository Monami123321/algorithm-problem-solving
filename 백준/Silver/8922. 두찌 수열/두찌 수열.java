import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tmp = new int[15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        outer:
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            next:
            while (cnt++ < 1000) {
                nextArr(arr);
                for (int i = 0; i < n; i++) {
                    if (arr[i] != 0) {
                        continue next;
                    }
                }
                sb.append("ZERO\n");
                continue outer;
            }
            sb.append("LOOP\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void nextArr(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            tmp[i] = Math.abs(arr[i + 1] - arr[i]);
        }
        arr[len - 1] = Math.abs(arr[len - 1] - arr[0]);
        System.arraycopy(tmp, 0, arr, 0, len - 1);
    }
}
