import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[100];
        arr[0] = arr[1] = arr[2] = 1;
        arr[3] = arr[4] = 2;
        for (int i = 5; i < 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            sb.append(arr[Integer.parseInt(br.readLine()) - 1]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
