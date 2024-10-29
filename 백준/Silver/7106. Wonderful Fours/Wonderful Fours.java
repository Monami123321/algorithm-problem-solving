import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        do {
            int num = getNum(arr);
            if (num != 0) {
                set.add(num);
            }
        } while (nextPermutation(arr));
        arr = set.stream().mapToInt(Integer::intValue).sorted().toArray();
        int len = arr.length;
        int cnt = 0;

        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                for (int k = j + 1; k < len - 1; k++) {
                    if (Arrays.binarySearch(arr, k + 1, len, arr[i] + arr[j] + arr[k]) < 0) {
                        continue;
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }

    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            --i;
        }
        if (i == 0) {
            return false;
        }
        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            --j;
        }
        swap(arr, i - 1, j);
        int k = arr.length - 1;
        while (i < k) {
            swap(arr, i++, k--);
        }
        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static int getNum(int[] arr) {
        int res = arr[0];
        if (res == 0) {
            return 0;
        }
        for (int i = 1; i < 5; i++) {
            res *= 10;
            res += arr[i];
        }
        return res;
    }


}
