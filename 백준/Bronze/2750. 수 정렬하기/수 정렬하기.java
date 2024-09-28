import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[6000];
        System.in.read(buffer);
        int n = nextInt(buffer);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt(buffer);
        }
        quickSort(arr);
//        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }

    static int nextInt(byte[] buffer) {
        int res = buffer[idx++];
        int sign = (char) res == '-' ? -1 : 1;
        if (sign == -1) {
            res = buffer[idx++];
        }
        res -= 48;
        int tmp;
        while (true) {
            tmp = buffer[idx++];
            if (tmp < '0' || tmp > '9') {
                break;
            }
            res *= 10;
            res += tmp - 48;
        }
        return res * sign;
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {
        int pivot = partition(arr, start, end);
        if (start + 1 < pivot) {
            quickSort(arr, start, pivot - 1);
        }
        if (pivot < end) {
            quickSort(arr, pivot, end);
        }
    }

    static int partition(int[] arr, int start, int end) {
        int val = arr[start + end >> 1];

        while (start <= end) {
            while (arr[start] < val) {
                start++;
            }
            while (arr[end] > val) {
                end--;
            }
            if (start <= end) {
                swap(arr, start++, end--);
            }
        }
        return start;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
