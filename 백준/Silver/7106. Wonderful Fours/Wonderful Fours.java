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
        int[] selected = new int[arr.length];
        for (int i = 0; i < 4; i++) {
            selected[selected.length - 1 - i] = 1;
        }
        int cnt = 0;

        do {
            int index = 0;
            int now = 0;
            int sum = 0;
            int d = 0;
            while (now < 4 && index < selected.length) {
                if (selected[index] != 0) {
                    if (now != 3) {
                        sum += arr[index];
                    } else {
                        d = arr[index];
                    }
                    now++;
                }
                index++;
            }
            if (sum == d) {
                cnt++;
            }
        } while (nextPermutation(selected));
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
