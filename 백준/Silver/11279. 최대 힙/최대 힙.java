import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                sb.append(get(arr)).append("\n");
            } else {
                insert(arr, cmd);
            }
        }
        System.out.print(sb);
        br.close();
    }

    static void insert(int[] arr, int val) {
        arr[size] = val;
        heapifyUp(arr, size++);
        
    }

    static int get(int[] arr) {
        if (size == 0) {
            return 0;
        }
        int res = arr[0];
        arr[0] = arr[--size];
        heapifyDown(arr, size, 0);
        return res;
    }

    static void heapifyUp(int[] arr, int node) {
        int parent = node - 1 >> 1;
        while (node > 0 && arr[node] > arr[parent]) {
            swap(arr, node, parent);
            node = parent;
            parent = node - 1 >> 1;
        }
    }

    static void heapifyDown(int[] arr, int size, int node) {
        int left = node << 1 | 1;
        int right = (node << 1) + 2;
        int samllest = node;

        if (left < size && arr[left] > arr[samllest]) {
            samllest = left;
        }

        if (right < size && arr[right] > arr[samllest]) {
            samllest = right;
        }

        if (samllest != node) {
            swap(arr, node, samllest);
            heapifyDown(arr, size, samllest);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
