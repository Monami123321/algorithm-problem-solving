import java.util.*;
class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int tmp = n + 1;
        while(true) {
            if(Integer.bitCount(tmp) == cnt) {
                return tmp;
            }
            tmp++;
        }
    }
}