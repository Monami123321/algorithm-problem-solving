class Solution {
    public int[] solution(int brown, int yellow) {
        int target = brown + yellow;
        int limit = (int)Math.sqrt(target);
        
        for(int i = 3; i <= limit; ++i) {
            if(target % i == 0) {
                int tmp = target / i;
                if((i - 2) * (tmp - 2) == yellow ) {
                    return new int[] {tmp, i};
                }
            }
        }
        return null;
    }
}