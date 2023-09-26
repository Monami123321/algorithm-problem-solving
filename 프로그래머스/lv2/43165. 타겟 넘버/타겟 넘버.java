import java.util.*;
class Solution {
    static void combination(boolean[] visited, int depth, int[] numbers, int target) { // true -> + false -> -
        
        if(depth == visited.length) {
            int res = 0;
            for (int i =0; i< visited.length;i++) {
                if(visited[i]) {
                    res += numbers[i];
                } else {
                    res -= numbers[i];
                }
                
            }
            if(res == target) {
                cnt++;
            }
            return;
            
        }
        
        
        visited[depth] = true;
        combination(visited,depth+1,numbers, target);
        visited[depth] = false;
        combination(visited,depth+1,numbers, target);
        
        
    }
    static int cnt;
    public int solution(int[] numbers, int target) {
        cnt = 0;
        combination(new boolean[numbers.length], 0 , numbers, target);
        
        return cnt;
    }
}