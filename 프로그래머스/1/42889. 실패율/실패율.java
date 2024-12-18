import java.util.*;
import java.util.stream.*;
class Solution {
    static class Node {
        double score;
        int id;
        public Node(int id) {
            this.id = id;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 2];
        int[] fail = new int[N + 2];
        for(int n : stages) {
            for(int j = 1; j<=n;++j) {
                arr[j]++;
            }
            fail[n]++;
        }
        List<Node> list = new ArrayList<>();
        for(int i = 1; i<=N; ++i) {
            Node node = new Node(i);
            if(arr[i] != 0) {
                node.score = (double)fail[i] / arr[i];
            }
            list.add(node);
        }
        Collections.sort(list, (a,b)-> {
            if(a.score != b.score) {
                return b.score - a.score < 0 ? -1 : b.score == a.score ? 0 : 1;
            }
            return a.id - b.id;
        });
        return list.stream().mapToInt(e -> e.id).toArray();
    }
}