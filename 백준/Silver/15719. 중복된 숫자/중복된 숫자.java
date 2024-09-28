import java.io.BufferedInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(System.in);
        int tmp;
        int n = 0;
        while ((tmp = bis.read()) != '\n') {
            n *= 10;
            n += tmp - 48;
        }
        boolean[] arr = new boolean[n];
        n = 0;
        while ((tmp = bis.read()) != '\n') {
            if (tmp == ' ') {
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
