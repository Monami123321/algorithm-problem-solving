import java.util.*;
import java.util.stream.*;
class Solution {
    public long solution(long n) {
        return Long.parseLong(String.valueOf(n).chars().
            mapToObj(i -> String.valueOf(i - 48)).
            sorted((a, b) -> b.compareTo(a)).
            collect(Collectors.joining("")));
    }
}