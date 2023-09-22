import java.util.Scanner;

public class Main {
	static void permutation(int depth, int n, int m, int r, int[] res, int index, boolean[] visited) {
		if (r == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(res[i]+" ");

			}
			System.out.println();
			return;

		}

		if (depth == n) {
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			res[index] = i+1;
			permutation(depth + 1, n, m, r + 1, res, index+1, visited);
			visited[i] = false;
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();

		permutation(0, n, m, 0, new int[n],0,new boolean[n]);

		scanner.close();
	}

}
