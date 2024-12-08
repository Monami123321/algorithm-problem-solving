import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        return Stream.iterate(0,i->i+1)
            .limit(signs.length)
            .reduce(0, (prev, cur) -> signs[cur] ? prev + absolutes[cur] : prev - absolutes[cur]);
    }
}