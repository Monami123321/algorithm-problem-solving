class Solution {
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        for(int i : ingredient) {
            sb.append(i);
        }
        String s = sb.toString();
        System.out.println(s.length());
        s = s.replace("1231", "");
        System.out.println(s.length());
        return ((ingredient.length  - s.length()) >> 2);
    }
}