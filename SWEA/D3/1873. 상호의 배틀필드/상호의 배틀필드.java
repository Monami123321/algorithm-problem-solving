import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {// SWEA 1873 상호의 배틀필드
	
	static int[] tankPos; // 현 전차 위치 r,c로 표현
	static int[] tankDelta; // 바라보고 있는 위치 델타로 표현 ㅡ> 포 쏘거나 움직이는 방향 \
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCases = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCases; tc++) { //  테스트케이스 수
			st = new StringTokenizer(br.readLine());   // h * w 배열 입력
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken()); 
			
			char[][] map = new char[height][width];
			for (int i = 0; i < height; i++) {
				map[i] = br.readLine().toCharArray();
			} // 입력 끝
			
			for (int i = 0; i < height; i++) { // 초기 탱크 위치, 방향 찾기 ㅡ> 스태틱 대입
				for (int j = 0; j < width; j++) {
					switch (map[i][j]) {
					case '<':
						tankPos = new int[] {i,j};
						tankDelta = new int[] {0,-1};
						
						break;
					case '>':
						tankPos = new int[] {i,j};
						tankDelta = new int[] {0,1};
						
						break;
					case '^':
						tankPos = new int[] {i,j};
						tankDelta = new int[] {-1,0};
	
						break;
					case 'v':
						tankPos = new int[] {i,j};
						tankDelta = new int[] {1,0};
						
						break;

					default: // do nothing
						break;
					}
					
				}
				
			} // 탱크 위치, 방향 설정 끝
			
			
			
			
			//int moveNum = Integer.parseInt(br.readLine());
			br.readLine(); // 안 쓰는 입력 날리기
			
			st = new StringTokenizer(br.readLine(),"UDLRS",true);
			while(st.hasMoreTokens()) {
				switch (st.nextToken()) {
				case "U": // Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
					tankDelta[0] = -1;
					tankDelta[1] = 0;
					if (tankPos[0]+tankDelta[0]<0 || tankPos[0]+tankDelta[0]>height-1 || tankPos[1]+tankDelta[1]<0 || tankPos[1]+tankDelta[1]> width-1 || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='-' ||  map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='*' || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='#' ) {
						map[tankPos[0]][tankPos[1]] = '^';
						break;
					}
					if(map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='.') {
						map[tankPos[0]][tankPos[1]] = '.'; // 원래 있던 자리는 평지로
						tankPos[0] += tankDelta[0];
						tankPos[1] += tankDelta[1];
						map[tankPos[0]][tankPos[1]] = '^'; // 움직인 자리는 위를 바라보는 탱크로
					}
					break;
				case "D": // Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
					tankDelta[0] = 1;
					tankDelta[1] = 0;
					if (tankPos[0]+tankDelta[0]<0 || tankPos[0]+tankDelta[0]>height-1 || tankPos[1]+tankDelta[1]<0 || tankPos[1]+tankDelta[1]> width-1 || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='-' || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='*' || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='#' ) {
						map[tankPos[0]][tankPos[1]] = 'v';
						break;
					}
					if(map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='.') {
						map[tankPos[0]][tankPos[1]] = '.'; // 원래 있던 자리는 평지로
						tankPos[0] += tankDelta[0];
						tankPos[1] += tankDelta[1];
						map[tankPos[0]][tankPos[1]] = 'v'; // 움직인 자리는 아래를 바라보는 탱크로
					}
					
					break;
				case "L": // Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
					tankDelta[0] = 0;
					tankDelta[1] = -1;
					if (tankPos[0]+tankDelta[0]<0 || tankPos[0]+tankDelta[0]>height-1 || tankPos[1]+tankDelta[1]<0 || tankPos[1]+tankDelta[1]> width-1 || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='-' || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='*' || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='#' ) {
						map[tankPos[0]][tankPos[1]] = '<';
						break;
					}
					if(map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='.') {
						map[tankPos[0]][tankPos[1]] = '.'; // 원래 있던 자리는 평지로
						tankPos[0] += tankDelta[0];
						tankPos[1] += tankDelta[1];
						map[tankPos[0]][tankPos[1]] = '<'; // 움직인 자리는 왼쪽을 바라보는 탱크로
					}
					
					break;
				case "R": // Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
					tankDelta[0] = 0;
					tankDelta[1] = 1;
					if (tankPos[0]+tankDelta[0]<0 || tankPos[0]+tankDelta[0]>height-1 || tankPos[1]+tankDelta[1]<0 || tankPos[1]+tankDelta[1]> width-1 || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='-' || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='*' || map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='#' ) {
						map[tankPos[0]][tankPos[1]] = '>';
						break;
					}
					if(map[tankPos[0]+tankDelta[0]][tankPos[1]+tankDelta[1]]=='.') {
						map[tankPos[0]][tankPos[1]] = '.'; // 원래 있던 자리는 평지로
						tankPos[0] += tankDelta[0];
						tankPos[1] += tankDelta[1];
						map[tankPos[0]][tankPos[1]] = '>'; // 움직인 자리는 오른쪽을 바라보는 탱크로
					}
					
					break;
				case "S": // Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
					outer:for (int i = 1; ; i++) {
						if (tankPos[0]+tankDelta[0]*i<0 || tankPos[0]+tankDelta[0]*i> height-1 || tankPos[1]+tankDelta[1]*i<0 || tankPos[1]+tankDelta[1]*i > width-1 )
							break; // 다음 인덱스가 범위를 넘어서는 경우 포탄 쏘는 무한 for문 탈출
						
						switch (map[tankPos[0]+tankDelta[0]*i][tankPos[1]+tankDelta[1]*i]) { // 다음 인덱스 값에 따라 포탄 결정
						case '*': // 벽돌을 만난 경우
							map[tankPos[0]+tankDelta[0]*i][tankPos[1]+tankDelta[1]*i] = '.'; // 벽돌을 평지로 바꿈
							break outer;
							
						case '#': // 강철을 만난 경우
							break outer; // 아무것도 바뀌지 않고 무한반복 탈출

						default: // do nothing
							break;
						}
							
					}
					
					break;

				default:
					break;
				}
				
				
				
			}
			
			
			
			System.out.printf("#%d ",tc);
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					System.out.print(map[i][j]);
					
				}
				System.out.println();
				
			} // 출력 끝 , 다음 케이스 위해 스태틱 초기화
			
			tankPos = null;
			tankDelta = null;
			
			
			
		}
		
		
		
		
		
		
		
		
		br.close();
	}
}