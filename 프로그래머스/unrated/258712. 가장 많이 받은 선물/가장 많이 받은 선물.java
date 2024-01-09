import java.util.*;
class Solution {
    static int fIndex;
    public int solution(String[] friends, String[] gifts) {
        fIndex = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        Arrays.stream(friends).forEach(e -> {
            hashMap.put(e,fIndex++);
        });
        int len = friends.length;
        int[][] map = new int[len][len];
        
        Arrays.stream(gifts).forEach(e -> {
            String[] tmp = e.split(" ");
            int from = hashMap.get(tmp[0]);
            int to = hashMap.get(tmp[1]);
            map[from][to]++;
        });
        int[] score = new int[len];
        
        for(int i = 0; i < len; i++) {
            int give = 0;
            int take = 0;
            for(int j = 0; j < len; j++) {
                give += map[i][j];
                take += map[j][i];
            }
            score[i] = give-take;
        }
        int[] sum = new int[len];
        for(int i = 0; i<len; i++) {
            for(int j = 0; j<len ; j++) {
                if(i==j) {
                    continue;
                }
                int tmp = 0;
                if(map[i][j] == map[j][i]) {
                    if(score[i]>score[j]) {
                        tmp++;
                    }
                } else {
                    if(map[i][j]>map[j][i]) {
                        tmp++;
                    }
                }
                sum[i] += tmp;
            }
        }
        int ans = 0;
        for(int i = 0; i<len; i++) {
            ans = Math.max(ans,sum[i]);
        }
        return ans;
        
        
    }
}