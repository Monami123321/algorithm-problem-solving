import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr);
        System.out.print(arr[k - 1]);
        br.close();
    }

    static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + right >> 1;
        mergeSort(arr, tmp, left, mid);
        mergeSort(arr, tmp, mid + 1, right);
        merge(arr, tmp, left, mid, right);
    }

    static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
        int l = left;
        int index = left;
        int r = mid + 1;

        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                tmp[index++] = arr[l++];
            } else {
                tmp[index++] = arr[r++];
            }
        }

        while (l <= mid) {
            tmp[index++] = arr[l++];
        }
        while (r <= right) {
            tmp[index++] = arr[r++];
        }
        System.arraycopy(tmp, left, arr, left, right - left + 1);
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
