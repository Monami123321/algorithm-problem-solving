import java.util.Scanner;

public class Solution {
	
	static int[] root;
	
	static void union(int x, int y) {
		root[findSet(y)] = findSet(x);
		
	}
	
	static int findSet(int x) {
//		if(x == root[x])
//			return x;
//		else return findSet(root[x]);
		if(x != root[x])
			root[x] = findSet(root[x]);
		return root[x];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int testCases = scanner.nextInt();
		
		for (int tc = 1; tc <= testCases; tc++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			root = new int[n+1];
			for (int i = 1; i < n+1; i++) {
				root[i] = i;
				
			}
			System.out.printf("#%d ",tc);
			for (int i = 0; i < m; i++) {
				int method = scanner.nextInt();
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				switch (method) {
				case 0:
					union(a, b);
					
					break;
				case 1:
					if(findSet(a) == findSet(b)) System.out.print(1);
					else System.out.print(0);
					
					break;
				
					
				

				default:
					break;
				}
				
				
				

			}
			System.out.println();
			
			
			
		}
		
		
		
		
		scanner.close();
	}

}
