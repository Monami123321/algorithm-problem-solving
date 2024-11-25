import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).sorted((a, b) -> -(a + b).compareTo(b + a)).toArray(String[]::new);
        return arr[0].equals("0") ? "0" : Arrays.stream(arr).collect(Collectors.joining(""));
    }
    
}