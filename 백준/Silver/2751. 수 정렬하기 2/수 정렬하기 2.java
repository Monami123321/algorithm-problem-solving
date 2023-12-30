import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, tmp, 0, arr.length - 1);

    }

    private static void sort(int[] arr, int[] tmp, int start, int end) {
        if (end > start) {
            int mid = (start + end) / 2;
            sort(arr, tmp, start, mid);
            sort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (tmp[left] <= tmp[right]) {
                arr[index++] = tmp[left++];
            } else {
                arr[index++] = tmp[right++];
            }
        }
        for (int i = 0; i <= mid - left; i++) {
            arr[index + i] = tmp[left + i];
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }


}
