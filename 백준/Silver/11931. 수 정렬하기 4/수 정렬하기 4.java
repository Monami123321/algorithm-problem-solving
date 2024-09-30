import java.io.IOException;

public class Main {
    static byte[] buffer = new byte[8000009];
    static int index = 0;

    public static void main(String[] args) throws IOException {
        System.in.read(buffer);
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        heapSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);

    }

    static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = (n >> 1) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int size, int node) {
        int left = node << 1 | 1;
        int right = (node << 1) + 2;
        int smallest = node;
        if (left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != node) {
            swap(arr, smallest, node);
            heapify(arr, size, smallest);
        }
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
