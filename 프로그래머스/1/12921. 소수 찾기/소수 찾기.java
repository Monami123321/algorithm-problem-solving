class Solution {
    public int solution(int n) {
        boolean[] visited = new boolean[n+1];
        int limit = (int)Math.sqrt(n);
        int ans = 0;
        for(int i = 2; i<=limit;++i) {
            if(visited[i]) {
                continue;
            }
            if(isPrime(i)) {
                ans++;
                int index = i << 1;
                while(index <= n) {
                    visited[index] = true;
                    index += i;
                }
            }
        }
        for(int i = limit + 1; i<=n; ++i) {
            if(!visited[i]) {
                ans++;
            }
        }
        return ans;
    }
    
    static boolean isPrime(int n) {
        if(n <= 3) {
            return true;
        }
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