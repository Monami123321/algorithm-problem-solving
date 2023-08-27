

import java.util.Scanner;

public class Main { // 백준 10157 자리배정
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int width = scanner.nextInt();
		int height = scanner.nextInt();

		int[][] map = new int[height][width];
		int[][] visited = new int[height][width];

		int ticket = scanner.nextInt();

		if (ticket > width * height) {
			System.out.println(0);
		} else {
			int step = 1;
			int r = 0;
			int c = 0;
			int dir = 0;

			while (ticket > 1) {
				map[r][c] = step++;
				visited[r][c]++;
				ticket--;

				if (r + dr[dir] < 0 || r + dr[dir] > height - 1 || c + dc[dir] < 0 || c + dc[dir] > width - 1
						|| visited[r + dr[dir]][c + dc[dir]] != 0) {
					dir = (dir+1)%4;

				}
				r += dr[dir];
				c += dc[dir];
			}
			
			System.out.printf("%d %d",c+1,r+1);

		}

		scanner.close();
	}

}
