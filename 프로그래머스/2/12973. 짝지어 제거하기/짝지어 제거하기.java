import java.util.*;

class Solution
{
    public int solution(String s)
    {
        LinkedList<Character> list = new LinkedList<>();
        int len = s.length();
        for(int i = 0; i < len; ++i) {
            list.add(s.charAt(i));
        }
        ListIterator<Character> iter = list.listIterator();
        char prev = iter.next();
        
        while(iter.hasNext()) {
            char now = iter.next();
            if(prev == now) {
                iter.remove();
                iter.previous();
                iter.remove();
                if(iter.hasPrevious()) {
                    iter.previous();
                    prev = iter.next();
                } else if(iter.hasNext()) {
                    prev = iter.next();
                }
            } else {
                prev = now;
            }
        }
        
        if(list.isEmpty()) {
            return 1;
        }
        return 0;
        
    }
}