import java.util.*;
import java.util.stream.*;
class Solution {
    static Set<Integer> set;
    public String solution(String s, String skip, int index) {
        set = skip.chars().mapToObj(e -> Integer.valueOf(e - 97)).collect(Collectors.toSet());
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            int t = index;
            int tmp = c - 97;
            while(t > 0) {
                tmp = (tmp + 1) % 26;
                if(!set.contains(tmp)) {
                    t--;
                }
            }
            sb.append((char)(tmp + 97));
        }
        return sb.toString();
    }
}