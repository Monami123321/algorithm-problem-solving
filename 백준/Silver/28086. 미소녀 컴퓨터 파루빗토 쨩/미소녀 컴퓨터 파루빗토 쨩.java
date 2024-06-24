import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        int index = 1;
        char operator;
        while (true) {
            operator = tmp.charAt(index++);
            if (operator < '0' || operator > '9') {
                break;
            }
        }
        long a = Long.parseLong(tmp.substring(0, index - 1), 8);
        long b = Long.parseLong(tmp.substring(index), 8);

        if (operator == '+') {
            if (a + b < 0) {
                System.out.println("-" + Long.toOctalString(-(a + b)));
            } else {
                System.out.println(Long.toOctalString(a + b));
            }
        } else if (operator == '-') {
            if (a < b) {
                System.out.println("-" + Long.toOctalString(b - a));
            } else {
                System.out.println(Long.toOctalString(a - b));
            }
        } else if (operator == '*') {
            if (a * b < 0) {
                System.out.println("-" + Long.toOctalString(-(a * b)));
            } else {
                System.out.println(Long.toOctalString(a * b));
            }
        } else {
            if (b == 0) {
                System.out.println("invalid");
            } else if ((a ^ b) < 0) {
                if (a % b == 0) {
                    System.out.println("-" + Long.toOctalString(-(a / b)));
                } else {
                    System.out.println("-" + Long.toOctalString(-(a / b) + 1));
                }
            } else {
                System.out.println(Long.toOctalString(a / b));
            }
        }
        br.close();
    }
}
