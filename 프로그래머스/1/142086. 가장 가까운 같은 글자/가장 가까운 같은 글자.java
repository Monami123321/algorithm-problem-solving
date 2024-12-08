import java.util.*;
class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int[] arr = new int[len];
        Map<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < len; ++i) {
            char now = s.charAt(i);
            int idx = hm.getOrDefault(now, -1);
            if(idx == -1) {
                arr[i] = -1;
            } else {
                arr[i] = i - idx;
            }
            hm.put(now, i);
        }
        return arr;
    }
}