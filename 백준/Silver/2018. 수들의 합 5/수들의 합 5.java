import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int left = 1;
        int right = 1;
        int sum = 1;
        int cnt = 0;
        while (right >= left) {
            if (sum == n) {
                cnt++;
                sum += ++right;
            } else if (sum < n) {
                sum += ++right;
            } else {
                sum -= left++;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
