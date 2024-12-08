class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        int lenT = t.length();
        int ans = 0;
        for(int i = 0; i <= lenT - len; ++i) {
            if(t.substring(i, i + len).compareTo(p) <= 0) {
                ans++;
            }
        }
        return ans;
    }
}