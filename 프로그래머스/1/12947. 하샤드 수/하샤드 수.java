class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int now = x;
        while(now > 0) {
            sum += now % 10;
            now /= 10;
        }
        return x % sum == 0;
    }
}