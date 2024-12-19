import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hm = Arrays.stream(completion).collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        int tmp;
        for(String s : participant) {
            if((tmp = hm.getOrDefault(s, 0)) == 0) {
                return s;
            }
            hm.put(s, tmp - 1);
        }
        return null;
    }
}