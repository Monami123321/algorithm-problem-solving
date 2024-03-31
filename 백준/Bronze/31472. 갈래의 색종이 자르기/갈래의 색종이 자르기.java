import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt() << 1;
        System.out.println((int) Math.sqrt(w) << 2);
        sc.close();
    }
}
