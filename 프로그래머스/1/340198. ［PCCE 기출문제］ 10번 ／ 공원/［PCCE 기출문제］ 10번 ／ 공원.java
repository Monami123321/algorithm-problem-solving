import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int n = mats.length;
        int r = park.length;
        int c = park[0].length;
        for(int i = n - 1; i >= 0; --i) {
            int len = mats[i];
            if(check(park, len, r, c)) {
                return len;
            }
        }
        return -1;
    }
    
    static boolean check(String[][] map, int len, int n, int m) {
        if(n < len || m < len) {
            return false;
        }
        for(int i = 0; i <= n - len; ++i) {
            outer:for(int j = 0; j <= m - len; ++j) {
                for(int k = 0; k < len; ++k) {
                    for(int l = 0; l < len; ++l) {
                        if(!map[i+k][j+l].equals("-1")) {
                            continue outer;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
