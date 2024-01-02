import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    static char[][] words;
    static HashMap<Character, Integer> map;
    static int size, ans;

    static int calDigit(char[] arr) {
        int res = map.get(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            res *= 10;
            res += map.get(arr[i]);
        }
        return res;
    }

    static void permutation(Character[] arr, int depth) {
        if (depth == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], 9 - i);
            }
            int sum = 0;
            for (int i = 0; i < words.length; i++) {
                sum += calDigit(words[i]);
            }
            ans = Math.max(ans, sum);
        }


        for (int i = depth; i < arr.length; i++) {
            swap(arr, i, depth);
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }

    }

    static void swap(Character[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        words = new char[n][];
        map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().toCharArray();
            for (int j = 0; j < words[i].length; j++) {
                set.add(words[i][j]);
            }
        }
        size = set.size();
        Character[] arr = set.toArray(new Character[size]);
        ans = 0;
        permutation(arr, 0);
        System.out.println(ans);


        br.close();
    }
}
