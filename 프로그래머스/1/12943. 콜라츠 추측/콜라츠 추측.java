class Solution {
    public int solution(int num) {
        int cnt = 0;
        long n = num;
        while(n != 1) {
            if((n & 1) ==0) {
                n >>= 1;
            } else {
                n = n * 3 + 1;
            }
            ++cnt;
            if(cnt > 500) {
                break;
            }
        }
        return cnt > 500 ? -1 : cnt;
    }
}