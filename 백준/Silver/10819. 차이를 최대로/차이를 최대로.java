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
        Arrays.sort(arr);
        int ans = 0;
        do {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            ans = Math.max(ans, sum);

        } while (nextPermutation(arr));
        System.out.println(ans);
        br.close();
    }

    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            --i;
        }
        if (i == 0) {
            return false;
        }
        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            --j;
        }
        swap(arr, i - 1, j);
        int k = arr.length - 1;
        while (i < k) {
            swap(arr, i++, k--);
        }
        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
