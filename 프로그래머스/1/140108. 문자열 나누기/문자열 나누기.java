class Solution {
    public int solution(String s) {
        int ans = 0;
        int index = 1;
        int len = s.length();
        int c = s.charAt(0);
        int cntP = 1;
        int cntN = 0;
        boolean flag = false;
        
        while(index < len) {
            if(s.charAt(index++) == c) {
                cntP++;
            } else {
                cntN++;
            }
            if(cntP == cntN) {
                ans++;
                cntP = 1;
                cntN = 0;
                if(index<len)  {
                    c = s.charAt(index++);
                } else {
                    flag = true;
                }
            }
        }
        return flag ? ans : ans + 1;
    }
}