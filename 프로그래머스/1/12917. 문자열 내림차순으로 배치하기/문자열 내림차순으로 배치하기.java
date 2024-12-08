import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        return s.chars().mapToObj(c->String.valueOf((char)c))
            .sorted((a, b) -> b.compareTo(a))
            .collect(Collectors.joining(""));
    }
}