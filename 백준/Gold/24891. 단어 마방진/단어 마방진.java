import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static char[][] map;
	static boolean flag = false;
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 마방진 길이
		N = Integer.parseInt(st.nextToken()); // 단어갯수
		map = new char[L][L];
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr);
		combination(arr, new boolean[N], 0, 0);

		if (flag) {
			StringBuilder sb = new StringBuilder();
			Collections.sort(list);
			String res = list.get(0);
			int len = res.length();
			int index = 0;
			while (index < len) {
				sb.append(res.charAt(index++));
				if (index % L == 0) {
					sb.append("\n");
				}
			}
			System.out.print(sb);
		} else {
			System.out.println("NONE");
		}

		br.close();
	}

	static boolean isPossible() {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				if (map[i][j] != map[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	static void combination(String[] arr, boolean[] visited, int depth, int pick) {
		if (pick == L) {
			int index = 0;
			int[] perm = new int[L];
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					perm[index++] = i;
				}
			}
			do {
				for (int i = 0; i < L; i++) {
					map[i] = arr[perm[i]].toCharArray();
				}
				if (isPossible()) {
					flag = true;
					list.add(makeStr());
					return;
				}

			} while (nextPermutation(perm));
			return;
		}
		if (depth == N) {
			return;
		}
		visited[depth] = true;
		combination(arr, visited, depth + 1, pick + 1);
		visited[depth] = false;
		combination(arr, visited, depth + 1, pick);
	}

	static boolean nextPermutation(int[] arr) {
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}
		int j = arr.length - 1;

		while (arr[i - 1] >= arr[j]) {
			j--;
		}
		swap(arr, j, i - 1);
		int k = arr.length - 1;
		while (k > i) {
			swap(arr, k--, i++);
		}
		return true;
	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	static String makeStr() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				sb.append(map[i][j]);
			}
		}
		return sb.toString();
	}
}
