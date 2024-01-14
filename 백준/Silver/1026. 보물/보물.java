import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arrA = new int[n];
        int[] arrB = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arrA[i] * arrB[n - 1 - i];
        }
        System.out.println(ans);


        br.close();

    }
}
