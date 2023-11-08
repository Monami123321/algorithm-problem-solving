import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[(int) (Math.sqrt(n) + 1) + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i * i;

		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == n) {
				System.out.println(1);
				return;
			}

		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] + arr[j] == n) {
					System.out.println(2);
					return;
				}
			}

		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				for (int k = j; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == n) {
						System.out.println(3);
						return;
					}
				}

			}

		}
		System.out.println(4);

		sc.close();
	}

}
