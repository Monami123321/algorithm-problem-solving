class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int cycle = 0;
        int len = s.length();
        while(len > 1) {
            cycle++;
            for(int i = 0; i < len; ++i) {
                if(s.charAt(i) == 48) {
                    cnt++;
                }
            }
            s = getNextStr(s);
            len = s.length();
        }
        return new int[] {cycle, cnt};
    }
    
    static String getNextStr(String s) {
        int len = s.length();
        int cnt = 0;
        for(int i = 0; i < len; ++i) {
            if(s.charAt(i) == 49) {
                cnt++;
            }
        }
        return Integer.toString(cnt, 2);
    }
}