class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        boolean isLeft = hand.equals("left");
        int left = 10;
        int right = 12;
        
        for(int n : numbers) {
            if(n == 1 || n == 4 || n == 7) {
                sb.append('L');
                left = n;
            } else if (n == 3 || n == 6 || n == 9) {
                sb.append('R');
                right = n;
            } else {
                if(n == 0) {
                    n = 11;
                }
                int ld = getDist(left - 1, n - 1);
                int rd = getDist(right - 1, n - 1);
                if(ld == rd) {
                    if(isLeft) {
                        sb.append('L');
                        left = n;
                    } else {
                        sb.append('R');
                        right = n;
                    }
                } else if (ld < rd) {
                        sb.append('L');
                        left = n;                    
                } else {
                        sb.append('R');
                        right = n;
                }
            }
        }
        return sb.toString();
        
    }
    
    static int getDist(int a, int b) {
        int ar = a / 3;
        int ac = a % 3;
        int br = b / 3;
        int bc = b % 3;
        return Math.abs(ar-br) + Math.abs(ac-bc);
    }
}