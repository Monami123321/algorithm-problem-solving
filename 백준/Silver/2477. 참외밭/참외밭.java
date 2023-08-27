
import java.util.Scanner;

public class Main { // 백준 2477 참외밭
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		int melon = scanner.nextInt(); // 평방미터당 참외 갯수
		
		int maxHeight = 0;
		int maxWidth = 0;
		int maxHeightInner = 0;
		int maxWidthInner = 0;
		
		int[] arr = new int[6];
		int[] arrDir = new int[6];
		for (int i = 0; i < 6; i++) {
			int d = scanner.nextInt();
			int val = scanner.nextInt();
			arr[i] = val;
			arrDir[i] = d;
			
			if (d == 1 || d == 2)
				maxHeight = Math.max(maxHeight, val);
			else
				maxWidth = Math.max(maxWidth, val);
		}
		
		int targetH = 0;
		int targetW = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==maxHeight && (arrDir[i]==1||arrDir[i]==2))
				targetH = i;
			if (arr[i]==maxWidth && (arrDir[i]==3||arrDir[i]==4))
				targetW = i;
		}
		
		if(targetH  == 0) {
			maxHeightInner = Math.abs(arr[1]-arr[5]);
		} else if (targetH == 5) {
			maxHeightInner = Math.abs(arr[4]-arr[0]);
		} else {
			maxHeightInner = Math.abs(arr[targetH-1]-arr[targetH+1]);
		}
		
		if(targetW  == 0) {
			maxWidthInner = Math.abs(arr[1]-arr[5]);
		} else if (targetW == 5) {
			maxWidthInner = Math.abs(arr[4]-arr[0]);
		} else {
			maxWidthInner = Math.abs(arr[targetW-1]-arr[targetW+1]);
		}
		
		System.out.println((maxHeight*maxWidth-maxHeightInner*maxWidthInner)*melon);
			
		scanner.close();
	}

}
