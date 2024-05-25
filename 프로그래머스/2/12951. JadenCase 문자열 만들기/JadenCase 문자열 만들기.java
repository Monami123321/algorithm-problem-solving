import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        if(arr[0] >= 97) {
            arr[0] ^= 32;
        }
        int len = arr.length;
        for(int i = 1; i < len; ++i) {
            if(arr[i] == ' ' || arr[i] < 65) {
                continue;
            }
            if(arr[i-1] == ' ' && arr[i] >= 97) {
                arr[i] ^= 32;
            } else if(arr[i-1] != ' ' && arr[i] < 97) {
                arr[i] ^= 32;
            }
        }
        return String.valueOf(arr);
    }
}