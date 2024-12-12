import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String[] babbling) {
        String[] arr = {"aya","ye","woo","ma"};
        return (int)Arrays.stream(babbling).filter(e -> {
            for(int i = 0; i<4;++i) {
                e = e.replace(arr[i],String.valueOf(i));
            }
            char prev = e.charAt(0);
            if(!Character.isDigit(prev)) {
                return false;
            }
            int len = e.length();
            for(int i = 1; i<len; ++i) {
                char c = e.charAt(i);
                if(c == prev || !Character.isDigit(c)) {
                    return false;
                }
                prev = c;
            }
            return true;
        }).count();
        
    }
}