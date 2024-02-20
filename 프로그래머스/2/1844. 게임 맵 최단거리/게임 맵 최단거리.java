import java.util.*;
class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int solution(int[][] maps) {
        int R = maps.length;
        int C = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,0});
        int ans = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int cost = now[2];
            if(r == R-1 && c == C-1) {
                ans = cost;
                break;
            }
            
            for(int i = 0; i <4 ; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                
                if(nr<0||nr>R-1||nc<0||nc>C-1||maps[nr][nc] == 0) {
                    continue;
                }
                q.add(new int[] {nr,nc, cost+1});
                maps[nr][nc] = 0;
            }
        }
        if(ans == 0) {
            return -1;
        }
        return ans+1;
    }
}