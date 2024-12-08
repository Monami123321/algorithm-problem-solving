class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        int len = sizes.length;
        int[][] arr = sizes;
        for(int i = 0; i < len; ++i) {
            if(arr[i][0] < arr[i][1]) {
                arr[i][0] ^= arr[i][1];
                arr[i][1] ^= arr[i][0];
                arr[i][0] ^= arr[i][1];
            }
            w = Math.max(w, arr[i][0]);
            h = Math.max(h, arr[i][1]);
        }
        return w * h;
    }
}