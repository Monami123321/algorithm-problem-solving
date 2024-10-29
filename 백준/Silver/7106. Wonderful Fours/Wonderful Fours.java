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
            int comb = getNum(arr);
            if (comb != 0) {
                set.add(comb);
            }
        } while (nextPermutation(arr));

        arr = set.stream().mapToInt(Integer::intValue).sorted().toArray();
        int cnt = 0;
        int len = arr.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                for (int k = j + 1; k < len - 1; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if (arr[i] + arr[j] + arr[k] == arr[l]) {
                            cnt++;
                        }
                    }

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
        if (arr[0] == 0) {
            return 0;
        }
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res *= 10;
            res += arr[i];
        }
        return res;
    }
}
