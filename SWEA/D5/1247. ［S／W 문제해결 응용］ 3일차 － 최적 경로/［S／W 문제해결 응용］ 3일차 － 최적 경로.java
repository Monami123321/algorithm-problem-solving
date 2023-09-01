
import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static int ans = Integer.MAX_VALUE; // 최단경로 최종 정답
	static int sum = 0;


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();
		for (int tc = 1; tc <= testCases; tc++) {
			int n = scanner.nextInt();
			arr = new int[n+2][2]; // 좌표관리배열 ㅡ> 회사 집 고객 순, [0] x [1] y
			
			for (int i = 0; i < n+2; i++) {
				arr[i][0] = scanner.nextInt();
				arr[i][1] = scanner.nextInt();
				
			}
			
			permutation(2, n);
			System.out.printf("#%d %d\n",tc,ans);
			ans = Integer.MAX_VALUE; // 다음 테스트 케이스 계산 위해 초기화

		}

		scanner.close();
	}
	
	static void permutation(int index,int n) { // 현재 처리 중인 인덱스, 총 처리해야하는 갯수 n
		if(index==n+2) { // 순열 완성됐을 때
			// 회사 출발0 ㅡ> 모든 고객 만나고(2~n+2) ㅡ> 집으로1
			sum += Math.abs(arr[0][0] - arr[2][0]);
			sum += Math.abs(arr[0][1] - arr[2][1]); // 회사 출발 ㅡ> 첫 고객에게
			for (int i = 2; i <= n; i++) { // 고객 1에서 고객 n 까지 돌기
				sum += Math.abs(arr[i][0]-arr[i+1][0]);
				sum += Math.abs(arr[i][1]-arr[i+1][1]);
				
			}
			sum += Math.abs(arr[n+1][0]-arr[1][0]); // 고객 다돌고 집가기
			sum += Math.abs(arr[n+1][1]-arr[1][1]);
			
			ans = Math.min(ans, sum); // 최단경로 갱신
			sum =0; // 다음 순열 계산 위해서 초기화
		}
		for (int i = index; i < n+2; i++) {
			swap(i, index);
			permutation(index+1, n);
			swap(i, index);
			
		}
		
		
		
	}
	
	
	static void swap(int a, int b) {
		int[] tmp = new int[2];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arr[a][i];
		}
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}