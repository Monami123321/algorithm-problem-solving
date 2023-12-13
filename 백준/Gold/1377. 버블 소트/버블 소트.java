import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2]; // {값, 인덱스}

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i][0] = val;
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i][1] - i;
            max = Math.max(max, tmp);

        }
        System.out.println(max + 1);

    }
}
