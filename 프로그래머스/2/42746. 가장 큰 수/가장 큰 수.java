import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        String res = Arrays.stream(numbers).mapToObj(String::valueOf).sorted((a, b) -> -(a + b).compareTo(b + a)).collect(Collectors.joining(""));
        return res.charAt(0) == 48 ? "0" : res;
    }
    
}