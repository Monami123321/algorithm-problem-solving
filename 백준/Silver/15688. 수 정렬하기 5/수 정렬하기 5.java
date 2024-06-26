import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(arr);
        System.out.print(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
        br.close();
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {
        int pivot = partition(arr, start, end);
        if (start < pivot - 1) {
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
                ++start;
            }
            while (arr[end] > val) {
                --end;
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
