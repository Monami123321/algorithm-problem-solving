class Solution {
    public int[] solution(String[] park, String[] routes) {
        int r = 0;
        int c = 0;
        char[][] map = new char[park.length][];
        for(int i = 0; i<park.length;i++) {
            map[i] = park[i].toCharArray();
        }
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0; j<map[0].length;j++) {
                if(map[i][j] == 'S') {
                    r = i;
                    c = j;
                    
                }
            }
        }
        int h = park.length;
        int w = park[0].length();
         // 시작 위치 설정 끝 (r,c)
        for(int i = 0; i<routes.length;i++) {
            String dir = routes[i].substring(0,1);
            int num = Integer.parseInt(routes[i].substring(2));
            int nr=r;
            int nc=c;
            outer:switch(dir) {
                    case "N":
                        nr = r-num;
                        if(nr<0 || nr > h-1 ) break;
                        for(int j = 1; j <= num; j++) {
                            if(map[r-j][c] == 'X') 
                                break outer;
                        }
                        r = nr;
                        
                    
                        break;
                    case "S":
                        nr = r+num;
                        if(nr<0 || nr > h-1 ) break;
                        for(int j = 1; j <= num; j++) {
                            if(map[r+j][c] == 'X') 
                                break outer;
                        }
                        r = nr;
                        break;
                    case "W":
                        nc = c-num;
                        if(nc<0 || nc > w-1 ) break;
                        for(int j = 1; j <= num; j++) {
                            if(map[r][c-j] == 'X') 
                                break outer;
                        }
                        c = nc;
                        break;
                    case "E":
                        nc = c+num;
                        if(nc<0 || nc > w-1 ) break;
                        for(int j = 1; j <= num; j++) {
                            if(map[r][c+j] == 'X') 
                                break outer;
                        }
                        c = nc;
                        break;
                    
            }
            
            
        }
        
        
        int[] answer = {r,c};
        return answer;
    }
}