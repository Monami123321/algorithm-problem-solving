class Solution {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int[] arr = new int[len + 1];
        System.arraycopy(sequence,0,arr,1,len);
        len++;
        int start = 1;
        int end = 1;
        for(int i = 2; i < len; ++i) {
            arr[i] += arr[i-1];
        }
        int ansLen = Integer.MAX_VALUE;
        int ansStart = 0;
        int ansEnd = 0;
        while(end < len && start <= end) {
            int val = arr[end] - arr[start - 1];
            if(val == k) {
                if(ansLen > end - start) {
                    ansStart = start - 1;
                    ansEnd = end - 1;
                    ansLen = end - start;
                }
                ++start;
                
            } else if(val < k) {
                ++end;
            } else {
                ++start;
            }
        }
        return new int[] {ansStart, ansEnd};
    }
}