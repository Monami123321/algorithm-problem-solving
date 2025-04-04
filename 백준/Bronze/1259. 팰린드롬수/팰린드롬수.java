import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            char[] arr = br.readLine().toCharArray();
            if (arr[0] == 48) {
                break;
            }
            if (isPalindrome(arr)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static boolean isPalindrome(char[] arr) {
        for (int i = 0; i < arr.length >> 1; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
