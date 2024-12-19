import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 2];
        Arrays.fill(arr, 1);
        arr[n + 1] = arr[0] = 0;
        Arrays.stream(lost).forEach(e->arr[e]--);
        Arrays.stream(reserve).forEach(e->arr[e]++);
        for(int i = 1; i <= n; ++i) {
            if(arr[i] == 0) {
                if(arr[i - 1] > 1) {
                    arr[i]++;
                    arr[i-1]--;
                } else if(arr[i + 1] > 1) {
                    arr[i]++;
                    arr[i + 1]--;
                }
            }
        }
        return (int)Arrays.stream(arr).filter(e->e>0).count();
    }
}