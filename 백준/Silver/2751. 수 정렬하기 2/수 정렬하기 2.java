import java.io.IOException;

public class Main {
    static byte[] buffer = new byte[9000009];
    static int index = 0;

    public static void main(String[] args) throws IOException {
        System.in.read(buffer);
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        countingSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void countingSort(int[] arr) {
        int max = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(arr[i], max);
        }
        int[] cnt = new int[max + 1000001];
        for (int i = 0; i < n; i++) {
            cnt[arr[i] + 1000000]++;
        }
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[--cnt[arr[i] + 1000000]] = arr[i];
        }
        System.arraycopy(sorted, 0, arr, 0, n);
    }


    static int nextInt() {
        int res = buffer[index++];
        boolean flag = res == '-';
        if (flag) {
            res = buffer[index++];
        }
        res -= 48;
        int tmp;
        while (true) {
            tmp = buffer[index++];
            if (tmp < 48 || tmp > 57) {
                break;
            }
            res *= 10;
            res += tmp - 48;
        }
        return flag ? -res : res;
    }
}

