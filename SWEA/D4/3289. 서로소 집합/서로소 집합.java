import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Solution {
	
	static int[] root;
	
	static void union(int x, int y) {
		root[findSet(y)] = findSet(x);
		
	}
	
	static int findSet(int x) {
		if(x != root[x])
			root[x] = findSet(root[x]);
		return root[x];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCases = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCases; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			root = new int[n+1];
			for (int i = 1; i < n+1; i++) {
				root[i] = i;
				
			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int method = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch (method) {
				case 0:
					union(a, b);
					
					break;
				case 1:
					if(findSet(a) == findSet(b)) sb.append(1);
					else sb.append(0);
					
					break;
				
					
				

				default:
					break;
				}
				
				
				

			}
			sb.append("\n");
			
			
			
		}
		
		System.out.println(sb);
		
		
		br.close();
	}

}
