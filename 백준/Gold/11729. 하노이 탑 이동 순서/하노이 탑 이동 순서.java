import java.util.Scanner;

public class Main {
	static void hanoi(int n, int from, int tmp, int to) {
		if (n == 1) {
			sb.append(from).append(" ").append(to).append("\n");
			k++;

			return;
		}
		hanoi(n - 1, from, to, tmp);
		sb.append(from).append(" ").append(to).append("\n");
		k++;
		hanoi(n - 1, tmp, from, to);
	}

	static StringBuilder sb;
	static int k;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		sb = new StringBuilder();
		k = 0;
		int n = scanner.nextInt();

		hanoi(n, 1, 2, 3);
		System.out.println(k);
		System.out.print(sb);
		scanner.close();
	}

}
