import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (!isValidJava(s) && !isValidC(s)) {
            System.out.println("Error!");
        } else if (isValidJava(s)) {
            System.out.println(toC(s));
        } else {
            System.out.println(toJava(s));
        }
        br.close();
    }

    static String toC(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c < 97) {
                sb.append("_").append((char) (c ^ 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String toJava(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '_') {
                sb.append((char) (arr[++i] ^ 32));
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    static boolean isValidJava(String s) {
        return !s.contains("_") && s.charAt(0) >= 97;
    }

    static boolean isValidC(String s) {
        char[] arr = s.toCharArray();
        if (arr[0] == '_' || arr[arr.length - 1] == '_' || arr[arr.length - 1] < 97) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '_') {
                if (arr[i + 1] == '_') {
                    return false;
                }
                continue;
            }
            if (arr[i] < 97) {
                return false;
            }
        }
        
        return true;
    }
}
