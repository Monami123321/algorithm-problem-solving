class Solution {
    public int solution(int n, long l, long r) {
        int ans = 0;
        for(long i = l; i <= r; ++i) {
            if(isOne(n, i)) {
                ++ans;
            }
        } 
        return ans;
    }
    static boolean isOne(int n, long target) {
        if (n == 0) {
            return true;
        }
        if(target % 5 == 3) {
            return false;
        } else {
            return isOne(n - 1, (target - 1) / 5 + 1);
        }
    }
}