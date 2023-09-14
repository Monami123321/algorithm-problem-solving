class Solution {
    public int solution(int n, int m, int[] section) {
        int index = section[0];
        int paint = index+m-1;
        int ans = 1;
        for(int i = 0; i<section.length;i++) {
            if(paint>=section[i]) continue;
            index = section[i];
            paint = index+m-1;
            ans++;
        }
        
        return ans;

    }
}