class Solution {
    boolean solution(String s) {
        int len = s.length();
        int p = 0;
        int y = 0;
        char c;
        for(int i = 0; i<len; ++i) {
            c = s.charAt(i);
            if(c == 'p' || c == 'P') {
                p++;
            } else if(c == 'y' || c == 'Y') {
                y++;
            }
        }
        return p == y;
    }
}