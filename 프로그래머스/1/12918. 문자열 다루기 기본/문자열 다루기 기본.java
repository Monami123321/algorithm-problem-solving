class Solution {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && s.chars().filter(a -> a > 64).count() == 0;
    }
}