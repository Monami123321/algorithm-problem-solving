class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i<n-2;++i) {
            for(int j = i+1; j<n-1; ++j) {
                for(int k = j+1; k<n;++k) {
                    int now = nums[i] + nums[j] + nums[k];
                    if(isPrime(now)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    static boolean isPrime(int n) {
        if((n & 1) == 0 || n % 3 == 0) {
            return false;
        }
        int limit = (int)Math.sqrt(n);
        for(int i = 5; i<=limit; i += 6) {
            if(n % i == 0 || n % (i+2) == 0) {
                return false;
            }
        }
        return true;
    }
}