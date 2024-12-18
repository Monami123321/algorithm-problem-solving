class Solution {
    public int solution(int[] wallet, int[] bill) {
        int b = wallet[0];
        int s = wallet[1];
        if(b < s) {
            b ^= s;
            s ^= b;
            b ^= s;
        }
        int cnt = 0;
        int r = bill[0];
        int c = bill[1];
        if(r < c) {
            r ^= c;
            c ^= r;
            r ^= c;
        }
        while(r > b || c > s) {
            cnt++;
            r >>= 1;
            if(r < c) {
                r ^= c;
                c ^= r;
                r ^= c;
            }
        }
        return cnt;
    }
}