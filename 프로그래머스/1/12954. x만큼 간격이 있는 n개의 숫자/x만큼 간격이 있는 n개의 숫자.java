import java.util.*;
import java.util.stream.*;
class Solution {
    public long[] solution(int x, int n) {
        return Stream.iterate((long)x, a -> a + x).limit(n).mapToLong(e->e).toArray();
    }
}