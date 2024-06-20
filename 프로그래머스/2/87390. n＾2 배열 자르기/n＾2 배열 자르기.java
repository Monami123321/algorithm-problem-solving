class Solution {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int) (right - left) + 1];
        int index = 0;
        for(long i = left; i <= right; ++i) {
            arr[index++] = getNum(n, i);
        }
        return arr;
        
    }
    static int getNum(int n, long target) {
        int r = (int) (target / n);
        int c = (int) (target % n);
        if(c <= r) {
            return r + 1;
        }
        return c + 1;
    }
}