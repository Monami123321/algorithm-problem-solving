import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        String[] sorted = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (!arr[i].equals(sorted[i])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("INCREASING");
            return;
        }
        flag = true;
        for (int i = 0; i < n; i++) {
            if (!arr[i].equals(sorted[n - 1 - i])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
        br.close();
    }
}
