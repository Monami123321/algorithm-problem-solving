import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        int pivot = partition(arr, start, end);
        if (pivot < end) {
            sort(arr, pivot, end);
        }
        if (pivot > start + 1) {
            sort(arr,start,pivot-1);
        }

    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (end >= start) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (end >= start) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
        return start;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");

        }
        System.out.print(sb);

        br.close();
    }
}
