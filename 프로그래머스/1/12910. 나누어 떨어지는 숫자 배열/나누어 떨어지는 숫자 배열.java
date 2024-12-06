import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] res = Arrays.stream(arr).filter(a -> a % divisor == 0).sorted().toArray();
        return res.length == 0 ? new int[] {-1} : res;
    }
}