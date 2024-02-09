import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1] - arr[i];
        }

        if (n == 2) {
            System.out.println(arr[1] - arr[0]);
            return;
        }
        int GCD = getGCD(arr[0], arr[1]);
        for (int i = 2; i < n - 1; i++) {
            GCD = getGCD(GCD, arr[i]);
        }

        System.out.println(GCD);
        br.close();
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
