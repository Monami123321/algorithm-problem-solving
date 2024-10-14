import java.io.IOException;

public class Main {
    static byte[] buffer = new byte[9000010];
    static int index = 0;

    public static void main(String[] args) throws IOException {
        System.in.read(buffer);
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        mergeSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
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
        int idx = left;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                tmp[idx++] = arr[l++];
            } else {
                tmp[idx++] = arr[r++];
            }
        }
        while (l <= mid) {
            tmp[idx++] = arr[l++];
        }
        while (r <= right) {
            tmp[idx++] = arr[r++];
        }
        System.arraycopy(tmp, left, arr, left, right - left + 1);
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
