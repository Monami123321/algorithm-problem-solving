import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('R', 0);
        hm.put('T', 0);
        hm.put('C', 0);
        hm.put('F', 0);
        hm.put('J', 0);
        hm.put('M', 0);
        hm.put('A', 0);
        hm.put('N', 0);
        
        int n = choices.length;
        for(int i = 0; i < n; ++i) {
            int val = choices[i];
            if(val == 4) {
                continue;
            }
            char s;
            if(val < 4) {
                s = survey[i].charAt(0);
                if(val == 1) {
                    val = 3;
                } else if (val == 3) {
                    val = 1;
                }
                
            } else {
                s = survey[i].charAt(1);
                if(val == 7) {
                    val = 3;
                } else if (val == 5) {
                    val = 1;
                } else {
                    val = 2;
                }
            }
            hm.merge(s, val, Integer::sum);
        }
        StringBuilder sb = new StringBuilder();
        if(hm.get('R') >= hm.get('T')) {
            sb.append('R');
        } else {
            sb.append('T');
        }
        if(hm.get('C') >= hm.get('F')) {
            sb.append('C');
        } else {
            sb.append('F');
        }
        if(hm.get('J') >= hm.get('M')) {
            sb.append('J');
        } else {
            sb.append('M');
        }
        if(hm.get('A') >= hm.get('N')) {
            sb.append('A');
        } else {
            sb.append('N');
        }
        return sb.toString();
    }
}