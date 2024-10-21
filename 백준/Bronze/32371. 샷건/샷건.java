import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[4][];
        for (int i = 0; i < 4; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        Set<Character> set = new HashSet<>();
        for (char c : br.readLine().toCharArray()) {
            set.add(c);
        }
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j < 9; j++) {
                if (check(arr, i, j, set)) {
                    System.out.println(arr[i][j]);
                    return;
                }
            }
        }
        br.close();
    }

    static boolean check(char[][] arr, int r, int c, Set<Character> set) {
        for (int i = r - 1; i < r + 2; i++) {
            for (int j = c - 1; j < c + 2; j++) {
                if (!set.contains(arr[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
