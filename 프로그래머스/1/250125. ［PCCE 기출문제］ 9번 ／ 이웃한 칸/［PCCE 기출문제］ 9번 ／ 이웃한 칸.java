import java.util.Objects;

class Solution {
    
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};
    
    public static int solution(String[][] board, int h, int w) {
        int answer = 0;
        int maxY = board.length;
        int maxX = board[0].length;
        
        String current = board[h][w];
        
        for(int i =0; i<4; i++){
            int dx = x[i] + w;
            int dy = y[i] + h;
            
            if(dx >=0 && dy >= 0 && dx < maxX && dy <maxY && Objects.equals(board[dy][dx], current)) {
                answer++;
            }
        }
        
        return answer;
    }
}