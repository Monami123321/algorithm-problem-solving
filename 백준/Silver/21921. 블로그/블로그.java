import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < x; i++) {
            max += arr[i];
        }
        int prev = max;
        int start = 0;
        int num = 1;
        while (x < n) {
            max += arr[x++];
            max -= arr[start++];
            if (max > prev) {
                prev = max;
                num = 1;
            } else if (max == prev) {
                num++;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(prev);
            System.out.println(num);
        }


        br.close();
    }
}
