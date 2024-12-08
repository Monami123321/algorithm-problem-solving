class Solution {
    public String solution(int n) {
        String ans = "수박".repeat(n >> 1);
        if((n & 1) != 0) {
            ans += "수";
        }
        return ans;
    }
}