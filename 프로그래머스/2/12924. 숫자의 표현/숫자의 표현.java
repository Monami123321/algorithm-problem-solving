class Solution {
    public int solution(int n) {
        int start = 1;
        int end = 2;
        int sum = 1;
        int cnt = 0;
        while(start < end) {
            if(sum == n) {
                cnt++;
                sum += end++;
            } else if(sum < n) {
                sum += end++;
            } else {
                sum -= start++;
            }
        }
        return cnt;
    }
}