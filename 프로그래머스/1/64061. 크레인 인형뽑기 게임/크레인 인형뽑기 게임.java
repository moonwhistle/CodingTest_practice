import java.util.Stack;

class Solution {

    static int[][] globalBoard;
    static Stack<Integer> basket = new Stack<>();
    static int cnt = 0;

    public static int solution(int[][] board, int[] moves) {
        globalBoard = board;
        pickDoll(moves);
        return cnt;
    }

    private static void pickDoll(int[] moves) {
        for (int move : moves) {
            int x = move - 1;
            for (int column = 0; column < globalBoard.length; column++) {
                if(globalBoard[column][x] != 0) {
                    pushBasket(globalBoard[column][x]);
                    globalBoard[column][x] = 0;
                    break;
                }
            }
        }
    }

    private static void pushBasket(int doll) {
        if(basket.isEmpty()) {
            basket.push(doll);
        } else if(basket.peek() == doll) {
            basket.pop();
            cnt += 2;
        } else {
            basket.push(doll);
        }
    }
}
