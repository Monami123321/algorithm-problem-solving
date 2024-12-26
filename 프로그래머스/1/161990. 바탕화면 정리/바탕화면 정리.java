class Solution {
    public int[] solution(String[] wallpaper) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        int ceil = Integer.MAX_VALUE;
        int floor = 0;
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(wallpaper[i].charAt(j) == '#') {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    ceil = Math.min(ceil, i);
                    floor = Math.max(floor, i);
                }
            }
        }
        return new int[] {ceil, left, floor+1, right+1};
    }
}