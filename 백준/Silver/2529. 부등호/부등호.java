import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] signs = new char[n];
        for (int i = 0; i < n; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        char[] comb = new char[10];
        for (int i = 0; i < n + 1; i++) {
            comb[9 - i] = 49;
        }

        do {
            char[] arr = getArr(comb, n + 1);

            do {
                if (validate(arr, signs)) {
                    StringBuilder sb = new StringBuilder();
                    for (char c : arr) {
                        sb.append(c);
                    }
                    list.add(sb.toString());
                }
            } while (nextPermutation(arr));
        } while (nextPermutation(comb));
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
        br.close();
    }

    static boolean nextPermutation(char[] arr) {
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
        while (k > i) {
            swap(arr, i++, k--);
        }
        return true;
    }

    static void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static char[] getArr(char[] comb, int n) {
        char[] res = new char[n];
        int index = 0;
        for (int i = 0; i < comb.length; i++) {
            if (comb[i] == 49) {
                res[index++] = (char) (i + 48);
            }
        }
        return res;
    }

    static boolean validate(char[] arr, char[] signs) {
        for (int i = 0; i < signs.length; i++) {
            char left = arr[i];
            char right = arr[i + 1];

            if (signs[i] == '<') {
                if (left > right) {
                    return false;
                }
            } else {
                if (right > left) {
                    return false;
                }
            }
        }
        return true;
    }

}
