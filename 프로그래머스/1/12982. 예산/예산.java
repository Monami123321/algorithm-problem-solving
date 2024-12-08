import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int index = 0;
        int cnt = 0;
        while(index < d.length) {
            if(d[index] > budget) {
                break;
            }
            budget -= d[index++];
            cnt++;
        }
        return cnt;
    }
}