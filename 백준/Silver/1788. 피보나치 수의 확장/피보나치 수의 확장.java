import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = System.in.read();
        boolean flag = n == '-';
        if (flag) {
            n = System.in.read();
        }
        n -= 48;
        int tmp;
        while ((tmp = System.in.read()) != '\n') {
            n *= 10;
            n += tmp - 48;
        }
        int[] arr = new int[n + 2];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1000000000;
        }
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            sb.append("0\n");
        } else if (flag) {
            if ((n & 1) == 0) {
                sb.append("-1\n");
            } else {
                sb.append("1\n");
            }
        } else {
            sb.append("1\n");
        }
        System.out.print(sb.append(arr[n]));
    }
}
