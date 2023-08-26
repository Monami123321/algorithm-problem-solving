
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		LinkedList<String> students = new LinkedList<String>();
		for (int i = 0; i < n; i++) {
			students.addLast(String.valueOf(i+1));
			
		}
		for (int i = 0; i < n; i++) {
			int tmp = scanner.nextInt();
			String move = students.remove(i);
			students.add(i-tmp, move);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(students.get(i)+" "); 
			
		}

		
		scanner.close();
	}
}