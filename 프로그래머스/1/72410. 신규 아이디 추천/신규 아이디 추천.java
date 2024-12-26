import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String new_id) {
        List<Character> list = new_id.toLowerCase().chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        Set<Character> set = new HashSet<>();
        for(int i = 97; i < 123; ++i) {
            set.add((char)i);
        }
        for(int i = 48; i < 58; ++i) {
            set.add((char)i);
        }
        set.add('-');
        set.add('_');
        set.add('.');
        int n = list.size();
        for(int i = 0; i < n; ++i) {
            if(!set.contains(list.get(i))) {
                list.remove(i--);
                n--;
            }
        }
        for(int i = 1; i < n; ++i) {
            if(list.get(i) == '.' && list.get(i - 1) == '.') {
                list.remove(i--);
                n--;
            }
        }
        if(n > 0 && list.get(0) == '.') {
            list.remove(0);
            n--;
        }
        if(n > 0 && list.get(n - 1) == '.') {
            list.remove(--n);
        }
        if(list.isEmpty()) {
            list.add('a');
            n++;
        }
        if(n > 15) {
            while(n > 15) {
                list.remove(--n);
            }
            if(list.get(n - 1) == '.') {
                list.remove(--n);
            }
        } else if(n < 3) {
            char tmp = list.get(n - 1);
            while(n++ < 3) {
                list.add(tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        return sb.toString();
        
    }
}