import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int now = 2;
        int val = 4;
        for (int i = 0; i < n; i++) {
            val <<= 2;
            val -= (now * 3) + now - 1;
            now = (now << 1) - 1;
        }
        System.out.println(val);
        sc.close();
    }
}
