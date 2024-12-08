import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int prev = arr[0];
        for(int i = 1; i < arr.length; ++i) {
            if(prev == arr[i]) {
                continue;
            }
            list.add(arr[i]);
            prev = arr[i];
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}