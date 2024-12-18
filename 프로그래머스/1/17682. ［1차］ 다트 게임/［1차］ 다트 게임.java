class Solution {
    public int solution(String dartResult) {
        String s = dartResult;
        int len = dartResult.length();
        int[] arr = new int[4];
        int index = 0;
        for(int i = 1; i < 4; ++i) {
            int score = s.charAt(index++) - 48;
            if(Character.isDigit(s.charAt(index))) {
                score *= 10;
                score += s.charAt(index++) -48;
            }
            char b = s.charAt(index++);
            if(b == 'D') {
                score *= score;
            } else if(b == 'T') {
                score = score * score * score;
            }
            if(index < len && !Character.isDigit(s.charAt(index))) {
                char p = s.charAt(index++);
                if(p == '*') {
                    arr[i - 1] <<= 1;
                    score <<= 1;
                } else {
                    score *= -1; 
                }
            }
            arr[i] = score;
        }
        return arr[1] + arr[2] + arr[3];
    }
}