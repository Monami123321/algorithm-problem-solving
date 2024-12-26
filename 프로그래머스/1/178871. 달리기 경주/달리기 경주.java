import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> hm = IntStream.range(0, players.length).boxed()
            .collect(Collectors.toMap(e -> players[e], e -> e));
        for(String s : callings) {
            int a = hm.get(s);
            hm.put(players[a], a - 1);
            hm.put(players[a - 1], a);
            swap(players, a, a - 1);
        }
        return players;
    }
    static void swap(String[] arr, int a, int b) {
        String tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}