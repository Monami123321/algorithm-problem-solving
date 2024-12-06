class Solution {
    public long solution(long n) {
        long sqrt = (long)Math.sqrt(n);
        return sqrt * sqrt == n ? (long)Math.pow(sqrt + 1, 2) : -1;
    }
}