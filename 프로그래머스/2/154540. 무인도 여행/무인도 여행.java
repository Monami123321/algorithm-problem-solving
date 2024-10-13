import java.util.*;

class Solution {
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int n, m;
    
    public int[] solution(String[] maps) {
        map = new char[maps.length][];
        for(int i = 0; i < maps.length; ++i) {
            map[i] = maps[i].toCharArray();
            
        }
        n = map.length;
        m = map[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(map[i][j] != 'X') {
                    int tmp = bfs(i, j);
                    if(tmp != 0) {
                        list.add(tmp);
                    }
                }
                
            }
        }
        if(list.isEmpty()) {
            return new int[] {-1};
        }
        return list.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    
    static int bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = map[startR][startC] - 48;
        q.add(new int[] {startR, startC});
        map[startR][startC] = 'X';
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            
            for(int i = 0; i < 4; ++i) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] == 'X') {
                    continue;
                }
                
                q.add(new int[] {nr, nc});
                cnt += map[nr][nc] - 48;
                map[nr][nc] = 'X';
            }
        }
        return cnt;
        
    }
    
    
}