import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent, dSize, cSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		dSize = new int[n + 1];
		cSize = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp == 0) {
				dSize[i]++;
			} else {
				cSize[i]++;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			int tmp = findSet(Integer.parseInt(br.readLine()));
			if (cSize[tmp] > dSize[tmp]) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

	static void union(int a, int b) {
		int parentA = findSet(a);
		int parentB = findSet(b);
		if (parentA == parentB) {
			return;
		}
		if (parentA > parentB) {
			parent[parentA] = parentB;
			dSize[parentB] += dSize[parentA];
			cSize[parentB] += cSize[parentA];
		} else {
			parent[parentB] = parentA;
			dSize[parentA] += dSize[parentB];
			cSize[parentA] += cSize[parentB];
		}
	}

	static int findSet(int a) {
		if (parent[a] != a) {
			return parent[a] = findSet(parent[a]);
		}
		return a;
	}
}
