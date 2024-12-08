class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        return new int[] {gcd, n / gcd * m};
    }
    static int getGCD(int a, int b) {
        int tmp;
        while(b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
        
}