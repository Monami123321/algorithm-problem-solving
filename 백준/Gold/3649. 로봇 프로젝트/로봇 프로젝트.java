import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10000000;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            if (n < 2) {
                System.out.println("danger");
                continue;
            }
            Arrays.sort(arr);
            int start = 0;
            int end = n - 1;
            boolean flag = false;

            while (start < end) {
                if (arr[start] + arr[end] > x) {
                    end--;
                } else if (arr[start] + arr[end] < x) {
                    start++;
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.printf("yes %d %d\n", arr[start], arr[end]);
            } else {
                System.out.println("danger");
            }
        }
        br.close();
    }
}
