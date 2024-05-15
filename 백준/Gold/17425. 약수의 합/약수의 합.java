import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] arr = new long[1_000_001];

    static {
        Arrays.fill(arr, 1L);
        for (int i = 2; i < 1000001; i++) {
            int index = i;
            while (index <= 1000000) {
                arr[index] += i;
                index += i;
            }
        }
        for (int i = 2; i < 1000001; i++) {
            arr[i] += arr[i - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append("\n");

        }
        System.out.print(sb);
        br.close();
    }

}
