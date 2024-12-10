import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] res = new int[score.length];
        int index = 0;
        int len = Math.min(k, score.length);
        for(int i = 0; i < len; ++i) {
            pq.add(score[i]);
            res[index++] = pq.peek();
        }
        for(int i = len; i < score.length;++i) {
            if(pq.peek() < score[i]) {
                pq.poll();
                pq.add(score[i]);
            }
                res[index++] = pq.peek();
            
        }
        return res;
    }
}