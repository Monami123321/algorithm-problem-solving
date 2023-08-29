import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[] check = new char[7];
	static int[] password = new int[8];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCases; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			//int m = Integer.parseInt(st.nextToken()); - 안 쓰는 변수 그냥 날림
			
			outer:for (int i = 0; i < n; i++) {
				String line = br.readLine();
				if(line.contains("1")) {
					for (int j = line.lastIndexOf("1"), step = 1, index=password.length-1, checkIndex = check.length-1; j > line.lastIndexOf("1")-56; j--,step++,checkIndex--) {
						check[checkIndex]=line.charAt(j);
						if(step%7 ==0) {
							switch (String.valueOf(check)) {
							case "0001101": 
								password[index]=0;
								index--;
								break;
							case "0011001":
								password[index]=1;
								index--;
								break;
							case "0010011":
								password[index]=2;
								index--;
								break;
							case "0111101":
								password[index]=3;
								index--;
								break;
							case "0100011":
								password[index]=4;
								index--;
								break;
							case "0110001":
								password[index]=5;
								index--;
								break;
							case "0101111":
								password[index]=6;
								index--;
								break;
							case "0111011":
								password[index]=7;
								index--;
								break;
							case "0110111":
								password[index]=8;
								index--;
								break;
							case "0001011":
								password[index]=9;
								index--;
								break;
							default:
								break;
							}
							check = new char[7];
							checkIndex = check.length;
						}
						
						
					}
					
					for (int k = i+1; k < n; k++) {
						br.readLine();
					}
					break outer;
					
					
				}
				

				
			} // 비밀번호 입력 끝
			
			// 비밀번호 검증 시작
			int odd = 0;
			int even = 0;
			int ans = 0;
			for (int j = 0; j < password.length; j++) {
				if((j+1)%2 ==0) even += password[j]; 
				 else odd += password[j];		
			}
			if((odd*3+even)%10 ==0) ans = odd+even;
			
			//출력 끝
			System.out.printf("#%d %d\n",tc,ans);	
		
		}
		
		
		
		
		
		br.close();
		
	}
}