class Solution {
    public String solution(String s) {
        int len = s.length();
        return (len & 1) == 0 ? s.substring((len >> 1) - 1, (len >> 1) + 1) : s.substring(len>>1,(len>>1)+1);
    }
}