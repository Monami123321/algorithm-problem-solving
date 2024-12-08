class Solution {
    public int solution(int left, int right) {
        int ans = (left + right) * (right-left+1) >> 1;
        int now = (int) Math.sqrt(left);
        if(now * now != left) {
            now++;
        }
        while(now * now <= right) {
            ans -= now * now << 1;
            now++;
        }
        return ans;
    }
}