import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] arr = {6,6,5,4,3,2,1};
        Set<Integer> set = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());
        int cnt = 0;
        int zero = 0;
        for(int n : lottos) {
            if(n == 0) {
                zero++;
            } else {
                if(set.contains(n)) {
                    cnt++;
                }
            }
        }
        return new int[] {arr[cnt + zero], arr[cnt]};
    }
}