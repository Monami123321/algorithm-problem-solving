import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int ref;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 1; i < n+1; i++) {
			parent[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int root;
		if (len > 0) {
			root = Integer.parseInt(st.nextToken());
		} else {
			root = 0;
		}
		for (int i = 1; i < len; i++) {
			union(root, Integer.parseInt(st.nextToken()));
		}
		ref = findSet(root);
		int[][] arr = new int[m][];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			int[] party = new int[len];
			party[0] = Integer.parseInt(st.nextToken());
			int now = findSet(party[0]);
			for (int j = 1; j < len; j++) {
				party[j] = Integer.parseInt(st.nextToken());
				union(now, party[j]);
			}
			arr[i] = party;
		}
		int ans = 0;
		outer:for (int i = 0; i < m; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (findSet(arr[i][j]) == ref) {
					continue outer;
				}
			}
			ans++;
		}
		System.out.println(ans);
		br.close();
	}

	static int findSet(int a) {
		if (parent[a] != a) {
			return parent[a] = findSet(parent[a]);
		}
		return parent[a];
	}

	static void union(int a, int b) {
		int parentA = findSet(a);
		int parentB = findSet(b);
		if (parentA == parentB) {
			return;
		}
		if (parentA == ref || parentB == ref) {
			parent[parentA] = parent[parentB] = ref;
			return;
		}
		if (parentA < parentB) {
			parent[parentB] = parentA;
		} else {
			parent[parentA] = parentB;
		}
	}
}
