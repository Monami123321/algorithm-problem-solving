class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int solution(String[][] board, int h, int w) {
        int cnt = 0;
        for(int i = 0; i < 4; ++i) {
            int nr = h + dr[i];
            int nc = w + dc[i];
            if(nr < 0 || nr> board.length - 1 || nc < 0 || nc > board.length - 1) {
                continue;
            }
            if(board[h][w].equals(board[nr][nc])) {
                cnt++;
            }
        }
        return cnt;
    }
}