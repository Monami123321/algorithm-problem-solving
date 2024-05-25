import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        Arrays.fill(lis, Integer.MAX_VALUE);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            int index = Arrays.binarySearch(lis, arr[i]);
            if (index < 0) {
                index = -(index + 1);
            }
            lis[index] = arr[i];
            cnt = Math.max(cnt, index + 1);
        }
        System.out.println(n - cnt);
        br.close();
    }
}
