import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            return new int[] {-1};
        }
        int target = Arrays.stream(arr).min().getAsInt();
        int[] res = new int[arr.length - 1];
        for(int i = 0, j = 0; i<res.length; ++i) {
            if(arr[j] == target) {
                i--;
                j++;
                continue;
            }
            res[i] = arr[j++];
        }
        return res;
    }
}