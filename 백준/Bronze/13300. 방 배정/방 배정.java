import java.util.Scanner;

public class Main {
	static int tmpNum;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); // 총 학생 수
		int k = scanner.nextInt(); //한 방에 배정 가능한 최대 인원
		
		int[] students = new int[12]; // 1~6 남 녀 순
		
		for (int i = 0; i < n; i++) {
			int gender = scanner.nextInt(); // 0 or 1  여 - 남 인덱스 조절용
			int grade = scanner.nextInt();
			students[grade*2-1-gender]++; // 입력 정보대로 해당 학생 세기
		}
		int ans =0; 
		for (int i = 0; i < students.length; i++) {
			ans += students[i]/k; // k로 나누어 떨어지면 그만큼 방 필요
			if (students[i]%k !=0) ans++; // 나머지가 있는 경우 한 개의 방 더 필요
		}
		System.out.println(ans);
		
		
		

		
		scanner.close();
	}
}