import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String X, String Y) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        X.chars().forEach(e->arr1[e-48]++);
        Y.chars().forEach(e->arr2[e-48]++);
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; --i) {
            if(arr1[i] > 0 && arr2[i] >0) {
                int tmp = Math.min(arr1[i], arr2[i]);
                while(tmp-- > 0) {
                    sb.append(i);
                }
            }
        }
        return sb.length() == 0 ? "-1" : sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}