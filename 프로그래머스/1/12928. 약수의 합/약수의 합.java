class Solution {
    public int solution(int n) {
        int limit = (int)Math.sqrt(n);
        int res = 0;
        for(int i = 1; i <= limit; ++i) {
            if(n % i == 0) {
                res += i + n / i;               
            }
        }
        if(limit * limit == n) {
            res -= limit;
        }
        return res;
    }
}