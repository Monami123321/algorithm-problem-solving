import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int tmp;
        int n = 0;
        while ((tmp = System.in.read()) != '\n') {
            n *= 10;
            n += tmp - 48;
        }
        boolean[] arr = new boolean[n];
        n = 0;
        while ((tmp = System.in.read()) != -1) {
            if (tmp == '\n' || tmp == ' ') {
                if (arr[n]) {
                    System.out.println(n);
                    return;
                }
                arr[n] = true;
                n = 0;
                continue;
            }
            n *= 10;
            n += tmp - '0';
        }
        System.out.println(n);
    }

}
