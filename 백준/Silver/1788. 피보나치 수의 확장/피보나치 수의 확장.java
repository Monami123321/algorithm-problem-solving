import java.io.IOException;

public class Main {
    static int[] arr = new int[2000001];
    static final int MOD = 1000000000;

    static {
        arr[1000001] = 1;
        for (int i = 2; i <= 1000000; i++) {
            arr[1000000 + i] = (arr[1000000 + i - 1] + arr[1000000 + i - 2]) % MOD;
        }
        for (int i = 1000000; i >=1 ; i--) {
            arr[i - 1] = (arr[i + 1] - arr[i]) % MOD;
        }
    }


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
        if (flag) {
            n = -n;
        }
        int ans = arr[n + 1000000];
        if (ans == 0) {
            System.out.print("0\n0");
        } else if (ans > 0) {
            System.out.println(1);
            System.out.println(ans);
        } else {
            System.out.println(-1);
            System.out.println(-ans);
        }
    }
}
