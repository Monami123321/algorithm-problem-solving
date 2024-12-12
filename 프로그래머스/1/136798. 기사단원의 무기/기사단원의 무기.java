class Solution {
    public int solution(int number, int limit, int power) {
        int res = 0;
        for(int i = 1; i<=number;++i) {
            int cnt = getCnt(i);
            res += cnt <= limit ? cnt : power;
        }
        return res;
    }
    
    static int getCnt(int n) {
        if(n <= 2) {
            return n;
        }
        int l = (int)Math.sqrt(n);
        int cnt = 2;
        for(int i = 2; i<=l;++i) {
            if(n % i == 0) {
                cnt += 2;
            }
        }
        return l * l == n ? cnt-1 : cnt;
    }
}