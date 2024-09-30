import java.io.IOException;

public class Main {
    static byte[] buffer = new byte[60000010];
    static int index = 0;

    public static void main(String[] args) throws IOException {
        System.in.read(buffer);
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        countingSort(arr);
        index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < n) {
            index++;
            sb.append(arr[index - 1]).append("\n");
            if (index % 1000 == 0) {
                System.out.print(sb);
                sb = new StringBuilder();
            }
        }
        System.out.print(sb);
    }

    static int nextInt() {
        int res = buffer[index++] - 48;
        int tmp;

        while (true) {
            tmp = buffer[index++];
            if (tmp < '0' || tmp > '9') {
                break;
            }
            res *= 10;
            res += tmp - 48;
        }
        return res;
    }

    static void countingSort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] cnt = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
        }
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] sorted = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[--cnt[arr[i]]] = arr[i];
        }
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
}
