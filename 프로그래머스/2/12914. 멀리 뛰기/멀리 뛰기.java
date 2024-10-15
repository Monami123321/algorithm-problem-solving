class Solution {
    static int MOD = 1234567;
    public long solution(int n) {
        int[] arr = new int[n + 2];
        arr[0] = 1;
        for(int i = 0; i < n; ++i) {
            arr[i + 1] += arr[i];
            arr[i + 1] %= MOD;
            arr[i + 2] += arr[i];
            arr[i + 2] %= MOD;
        }
        return arr[n];
    }
}