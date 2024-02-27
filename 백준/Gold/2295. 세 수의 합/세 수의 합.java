import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int[] targetArr = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                targetArr[index++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(targetArr);

        for (int i = n-1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (binarySearch(targetArr, arr[i] - arr[j])) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
        br.close();
    }
    static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (end >= start) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
