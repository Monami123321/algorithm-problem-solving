import java.io.IOException;

public class Main {
    static byte[] buffer = new byte[5000000];
    static int index = 0;

    public static void main(String[] args) throws IOException {
        System.in.read(buffer);
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        quickSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
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
            if (tmp < '0' || tmp > '9') {
                break;
            }
            res *= 10;
            res += tmp - 48;
        }
        return flag ? -res : res;
    }
}
