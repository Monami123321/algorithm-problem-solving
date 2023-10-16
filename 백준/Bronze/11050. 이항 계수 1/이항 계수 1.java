import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int ans = 1;
		int tmp = 0;
		while (tmp < k) {
			ans *= n - tmp;
			ans /= (tmp + 1);
			tmp++;
		}
		System.out.println(ans);

		scanner.close();
	}

}
