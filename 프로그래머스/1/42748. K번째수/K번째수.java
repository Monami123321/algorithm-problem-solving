import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        for(int i = 0; i<commands.length;++i) {
            int[] com = commands[i];
            int tmp[] = new int[com[1] - com[0] +1];
            for(int j = com[0]-1, index = 0; j<=com[1]-1;++j) {
                tmp[index++] = array[j];
            }
            Arrays.sort(tmp);
            ans[i] = tmp[com[2] - 1];
        }
        return ans;
    }
}