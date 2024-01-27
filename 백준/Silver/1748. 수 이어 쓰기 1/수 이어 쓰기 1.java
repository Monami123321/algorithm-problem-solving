import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 9;
        int limit = 9;
        int prev = 0;
        int num = 1;
        int ans = 0;
        while (true) {
            if (n > limit) {
                ans += cnt * num;
                prev = limit;
                limit *= 10;
                limit += 9;
                cnt *= 10;
                num++;
                continue;
            }
            ans += (n - prev) * num;
            break;
        }
        System.out.println(ans);


        sc.close();
    }
}
