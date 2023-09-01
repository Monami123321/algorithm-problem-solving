import java.util.Scanner;

public class Solution {
	static int[] arrA;
	static int sumA =0; // 규영이 점수
	static int sumB = 0; // 인영이 점수
	static int win = 0;
	static int lose = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt(); // 총 테스트 케이스 수
		for (int tc = 1; tc <= testCases; tc++) { // 테스트 케이스 반복 시작
			arrA = new int[9]; // 규영이의 카드 배열
			boolean[] cards = new boolean[19]; // 어떤 카드가 들어갔는지 체크
			for (int i = 0; i < arrA.length; i++) { // 규영이 카드 입력
				arrA[i] = scanner.nextInt();
				cards[arrA[i]] = true; // 뽑은 카드는 전체 카드 목록에서 체크
			}

			int[] arrB = new int[9]; // 인영이의 카드 배열
			for (int i = 1, tmpIndex = 0; i < cards.length; i++) { // 전체 카드에서 인덱스 1부터 돌면서 false(규영이가 뽑지 않은 카드) 를 인영이 카드
																	// 배열에 입력
				if (!cards[i])
					arrB[tmpIndex++] = i;
			} // 인영이 카드 입력 끝
			permutation(arrB, 9, 0);
			
			System.out.printf("#%d %d %d\n",tc,win,lose);
			win=0;
			lose=0;
			
			
			

		}

		scanner.close();
	}
	
	static void permutation(int[] arr, int n, int index) { //n개 요소를 가진 배열의 n!개 순열을 뽑아내는 순열 메서드
		if(n == index) { // 마지막 요소까지 처리해서 하나의 순열 완성 된 상황
			for (int i = 0; i < 9; i++) { // 규영이 인영이 배열 순회하며 점수 비교 ㅡ> 총점
				int tmp = arrA[i]+arr[i];
				if (arrA[i]>arr[i]) {
					sumA += tmp;
				} else if (arrA[i]<arr[i]) {
					sumB += tmp;
				}
			}
			if (sumA>sumB) win++; // 총점에 따라 승패 카운팅
			else if (sumA<sumB) lose++;
			//System.out.println("win:" +win);
			//System.out.println("lose:" +lose);
			sumA=0;
			sumB=0;
		}
		
		for (int i = index; i < n; i++) { // 어떤 배열에서 각 요소가 모든 요소와 한 번 씩 스왑하면 n!개 순서가 다른 순열이 생김
			swap(arr, i, index); // 자기 자신을 포함해서 끝까지 순회하며 자리 바꾸기
			permutation(arr, n, index+1); // 재귀호출
			swap(arr, i, index); // 제자리 찾기
		}
		
		
		
	}
	
	static void swap(int[] arr, int a, int b) { // 순열 만들기 위한 스왑 메서드
		int tmp = arr[a];
		arr[a] = arr[b]; 
		arr[b] = tmp; 
		return;		
	}
	
}