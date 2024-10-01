import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        st = new StringTokenizer(br.readLine());
        int[] ops = new int[n - 1]; // 0+ 1- 2* 3/
        int index = 0;
        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                ops[index++] = i;
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        do {
            int val = arr[0];
            index = 1;
            for (int i = 0; i < n - 1; i++) {
                switch (ops[i]) {
                    case 0:
                        val += arr[index++];
                        break;
                    case 1:
                        val -= arr[index++];
                        break;
                    case 2:
                        val *= arr[index++];
                        break;
                    case 3:
                        val /= arr[index++];
                        break;
                    default:
                        break;
                }
            }
            max = Math.max(max, val);
            min = Math.min(min, val);
        } while (nextPermutation(ops));
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
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
