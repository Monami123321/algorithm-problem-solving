import java.io.IOException;

public class Main {
    static byte[] buffer = new byte[900000];
    static int index = 0;

    public static void main(String[] args) throws IOException {
        System.in.read(buffer);
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        arr = countingSort(arr);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, arr[i] + i + 2);
        }
        System.out.println(ans);
    }

    static int nextInt() {
        int res = buffer[index++] - 48;
        int tmp;
        while (true) {
            tmp = buffer[index++];
            if (!Character.isDigit(tmp)) {
                break;
            }
            res *= 10;
            res += tmp - 48;
        }
        return res;
    }

    static int[] countingSort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] cnt = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
        }
        for (int i = max - 1; i >= 0; i--) {
            cnt[i] += cnt[i + 1];
        }
        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sorted[--cnt[arr[i]]] = arr[i];
        }
        return sorted;
    }
}
