
import java.util.Scanner;

public class Main { // 백준 2527 직사각형
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);



		for (int i = 0; i < 4; i++) {
			char ans;
			int c1L = scanner.nextInt();
			int r1L = scanner.nextInt();
			int c1R = scanner.nextInt();
			int r1R = scanner.nextInt();
			int c2L = scanner.nextInt();
			int r2L = scanner.nextInt();
			int c2R = scanner.nextInt();
			int r2R = scanner.nextInt();

			// 4가지 경우 각각
			
			if(c1R<c2L || c1L>c2R || r1L>r2R || r1R<r2L) ans = 'd';
			else if ((c1R==c2L && r1R==r2L) || (c1L==c2R && r1R == r2L) || (c1R == c2L && r1L==r2R)  || (c1L==c2R && r1L == r2R)) ans = 'c';
			else if (r1R == r2L && (c1R>c2L && c1L<c2R) ||c1R == c2L &&(r1R>r2L && r1L<r2R) || c1L==c2R && (r1R>r2L && r1L<r2R) || r1L == r2R && (c1R>c2L && c1L<c2R)) ans = 'b';
			else ans = 'a';
			
			
			System.out.println(ans);
			
			

		}

		scanner.close();

	}
}