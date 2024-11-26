import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        return Arrays.stream(arr).reduce(1, Solution::getLCM);
    }
    
    static int getLCM(int a, int b) {
        return a / getGCD(a, b) * b;
    }
    
    
    static int getGCD(int a, int b) {
        int tmp;
        while(b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}