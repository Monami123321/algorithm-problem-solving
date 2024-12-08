import java.util.stream.*;
class Solution {
    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length)
            .reduce(0, (prev, cur) -> prev + a[cur] * b[cur]);
    }
}