import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (!prevPermutation(arr)) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.print(sb);
        }
        br.close();
    }

    static boolean prevPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = arr.length - 1;
        while (arr[j] >= arr[i - 1]) {
            j--;
        }
        swap(arr, i - 1, j);
        int k = arr.length - 1;
        while (k > i) {
            swap(arr, k--, i++);
        }
        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
