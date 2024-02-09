import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = {0, -1, -1, 1, -1, 1, 2, -1, 2, 3, 2, 3, 4, 3, 4, 3};
        if (n <= 15) {
            System.out.println(arr[n]);
            return;
        }
        int cnt = (n / 5) - 2;
        int index = (n % 5) + 10;
        if (arr[index] == -1) {
            System.out.println(-1);
        } else {
            System.out.println(cnt + arr[index]);
        }

        sc.close();
    }
}
