import java.util.Arrays;
import java.util.stream.*;
class Solution {
    public double solution(int[] arr) {
        return (double)Arrays.stream(arr).sum() / arr.length;
    }
}