class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = getTime(video_len);
        int now = getTime(pos);
        int opSt = getTime(op_start);
        int opEd = getTime(op_end);
        for(String com : commands) {            
            if(opSt <= now && now <= opEd) {
                now = opEd;
            }
            if(com.equals("prev")) {
                now = Math.max(0, now - 10);
            } else {
                now = Math.min(len, now + 10);
            }
        }
        if(opSt <= now && now <= opEd) {
            now = opEd;
        }        
        return getStr(now);
    }
    static int getTime(String s) {
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    static String getStr(int t) {
        int h = t / 60;
        int m = t % 60;
        StringBuilder sb = new StringBuilder();
        if(h < 10) {
            sb.append(0);
        }
        sb.append(h).append(":");
        if(m < 10) {
            sb.append(0);
        }
        sb.append(m);
        return sb.toString();
    }
}