class Solution {
    public String solution(int a, int b) {
        int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        for(int i = 1; i<13;++i) {
            month[i] += month[i-1];
        }
        String[] arr = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        return arr[(month[a - 1] + b + 4) % 7];
    }
}