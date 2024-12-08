import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] numbers) {
        return Arrays.stream(numbers).reduce(45,(prev, cur) -> prev - cur);
    }
}