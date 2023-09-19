import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static List<Person> pList;
	static Stair[] stairs;
	static int ans;

	static class Person {
		int r;
		int c;
		int dist0;
		int dist1;
		int stTime;

		static Comparator<Person> dist0Comperator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.dist0 - o2.dist0;
			}

		};

		static Comparator<Person> dist1Comperator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {

				return o1.dist1 - o2.dist1;
			}

		};

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static class Stair {
		int r;
		int c;
		int reqTime;

		public Stair(int r, int c, int reqTime) {
			super();
			this.r = r;
			this.c = c;
			this.reqTime = reqTime;
		}

	}

	static void combination(int depth, boolean[] visited) {
		if (depth == visited.length) {
			// true -> 계단0 false -> 계단1
			List<Person> line0 = new LinkedList<>();
			List<Person> line1 = new LinkedList<>();
			Queue<Person> down0 = new LinkedList<>();
			Queue<Person> down1 = new LinkedList<>();
			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					line0.add(pList.get(i));
				else
					line1.add(pList.get(i));

			}
			Collections.sort(line0, Person.dist0Comperator);
			Collections.sort(line1, Person.dist1Comperator);

			// int t = Math.min(line0.get(0).dist0, line1.get(0).dist1)+1;
			int t = 0;
			while (true) {
				// 0. ans보다 이미 t가 크면 그만
				if (ans <= t)
					break;

				// 1. 계단(down) 체크 ㅡ> 내보내기
				if (!down0.isEmpty()) {
					int tmpSize = down0.size();
					for (int i = 0; i < tmpSize; i++) {
						if (t - down0.peek().stTime == stairs[0].reqTime) {
							down0.poll();
						}

					}
				}
				if (!down1.isEmpty()) {
					int tmpSize = down1.size();
					for (int i = 0; i < tmpSize; i++) {
						if (t - down1.peek().stTime == stairs[1].reqTime) {
							down1.poll();
						}

					}
				}

				// 2. 계단 비었으면 ㅡ> 차례대로 큐에 넣기
				for (int i = 0; i < 3; i++) {
					if (down0.size() < 3 && !line0.isEmpty()) {
						if (line0.get(0).dist0 + 1 <= t) {
							Person tmp = line0.remove(0);
							tmp.stTime = t;
							down0.add(tmp);
						}

					}
				}
				for (int i = 0; i < 3; i++) {
					if (down1.size() < 3 && !line1.isEmpty()) {
						if (line1.get(0).dist1 + 1 <= t) {
							Person tmp = line1.remove(0);
							tmp.stTime = t;
							down1.add(tmp);
						}

					}
				}

				// 3. 0번 1번 줄 모두 비었으면 끝

				if (line0.isEmpty() && line1.isEmpty() && down0.isEmpty() && down1.isEmpty()) {
					ans = Math.min(t, ans);
					return;
				}

				t++;

			}
			return;
		}
		visited[depth] = true;
		combination(depth + 1, visited);
		visited[depth] = false;
		combination(depth + 1, visited);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {
			int n = scanner.nextInt();

			int[][] map = new int[n][n];
			pList = new ArrayList<>();
			stairs = new Stair[2];

			for (int i = 0, idx = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = scanner.nextInt();
					if (map[i][j] == 1) {
						pList.add(new Person(i, j));
					} else if (map[i][j] > 1) {
						stairs[idx++] = new Stair(i, j, map[i][j]);
					}

				}
			}
			for (int i = 0; i < pList.size(); i++) {
				Person p = pList.get(i);
				p.dist0 = Math.abs(p.r - stairs[0].r) + Math.abs(p.c - stairs[0].c);
				p.dist1 = Math.abs(p.r - stairs[1].r) + Math.abs(p.c - stairs[1].c);

			}

			boolean[] visited = new boolean[pList.size()];
			ans = Integer.MAX_VALUE;

			combination(0, visited);

			System.out.printf("#%d %d\n", tc, ans);

		}

		scanner.close();
	}

}
