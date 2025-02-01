import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(recurr(arr, 0, n - 1, n));
        br.close();
    }

    static int recurr(int[] arr, int left, int right, int len) {
        if (len == 2) {
            return arr[left] + arr[right];
        }
        if (len == 1) {
            return arr[left];
        }
        int mid = left + (len >> 1);
        int l = arr[left];
        for (int i = left + 1; i < mid; i++) {
            l = getGCD(l, arr[i]);
        }
        int r = arr[mid];
        for (int i = mid + 1; i <= right; i++) {
            r = getGCD(r, arr[i]);
        }
        return Math.max(l + recurr(arr, mid, right, right - mid + 1), r + recurr(arr, left, mid - 1, mid - left));
    }

    static int getGCD(int a, int b) {
        int tmp;
        while (b > 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
