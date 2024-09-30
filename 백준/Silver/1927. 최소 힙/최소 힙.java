import java.io.IOException;

public class Main {
    static byte[] buffer = new byte[1300000];
    static int index = 0;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        System.in.read(buffer);
        int n = nextInt();
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cmd = nextInt();
            if (cmd == 0) {
                sb.append(poll(arr)).append("\n");
            } else {
                insert(arr, cmd);
            }
        }
        System.out.print(sb);
    }

    static void insert(int[] arr, int val) {
        arr[size] = val;
        heapifyUp(arr, size++);
    }

    static int poll(int[] arr) {
        if (size == 0) {
            return 0;
        }
        int res = arr[0];
        arr[0] = arr[--size];
        heapifyDown(arr, 0);
        return res;
    }

    static void heapifyDown(int[] arr, int node) {
        int smallest = node;
        int left = node << 1 | 1;
        int right = (node << 1) + 2;
        if (left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != node) {
            swap(arr, smallest, node);
            heapifyDown(arr, smallest);
        }
    }

    static void heapifyUp(int[] arr, int node) {
        int parent = (node - 1) >> 1;
        while (node > 0 && arr[node] < arr[parent]) {
            swap(arr, parent, node);
            node = parent;
            parent = (node - 1) >> 1;
        }
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
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
}
