import java.util.*;
class Solution {
    
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int box = score.length/m;
        int index = 1;
        int len = score.length-1;
        for(int i = 1; i<=box;i++) {
             answer += score[len-m*i+1]*m;
        }

        return answer;
        
        
    }
}