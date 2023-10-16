import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 크루스칼로 풀이

	static class Edge {
		int from, to, weight;

		public Edge() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	static int[] parent;

	static int findset(int x) {
		if (parent[x] != x) {
			parent[x] = findset(parent[x]);
		}
		return parent[x];

	}

	static void union(int x, int y) {
		parent[findset(y)] = findset(x);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[m + 1];
		parent = new int[n + 1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;

		}
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new Edge();

		}
		for (int i = 0; i < m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i].from = from;
			edges[i].to = to;
			edges[i].weight = weight ^ 1;

		}
		Arrays.sort(edges, 1, m + 1, (e1, e2) -> e1.weight - e2.weight); // 가중치 기준 오름차순 정렬 입구 **입구 제외해야함

		int pick = 0;
		int index = 1;
		int cnt = 0; // 가중치 합 계산
		union(0, 1); // 입구 -1번까지 무조건 연결하고 시작
		while (pick < n - 1) {
			Edge edge = edges[index];

			if (findset(edge.from) != findset(edge.to)) {
				union(edge.from, edge.to);
				cnt += edge.weight;
				pick++;
			}
			index++;

		}
		cnt += edges[0].weight; // 입구에서 1번까지 무조건 계산
		int tmp = cnt * cnt; // 피로도 최소값 계산 끝

		// 최악계산 시작
		Arrays.sort(edges, 1, m + 1, (e1, e2) -> e2.weight - e1.weight);
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;

		} // parent 배열 초기화
			// 변수 전부 초기화
		union(0, 1); // 입구 -1번까지 무조건 연결하고 시작
		pick = 0;
		index = 1;
		cnt = 0; // 가중치 합 계산
		while (pick < n - 1) {
			Edge edge = edges[index];

			if (findset(edge.from) != findset(edge.to)) {
				union(edge.from, edge.to);
				cnt += edge.weight;
				pick++;
			}
			index++;

		} // cnt에 최악조건시 sqrt피로도 저장됨
		cnt += edges[0].weight;

		System.out.println(cnt * cnt - tmp);

		br.close();

	}

}
