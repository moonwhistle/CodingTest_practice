class Solution {

    static int[][] boxes;

    public static int solution(int n, int w, int num) {
        makeBoxesSize(n, w);
        makeBoxes(n, w);
        
        return findOutBox(num);
    }

    private static int findOutBox(int num) {
        int row = 0;
        int column = 0;
        int cnt = 0;

        for(int i = 0; i <boxes.length; i++) {
            for(int j = 0; j<boxes[i].length; j++) {
                if(boxes[i][j] == num) {
                    row = i;
                    column = j;
                    break;
                }
            }
        }

        for(int i = row - 1; i>=0; i--) {
            if(boxes[i][column] != 0) {
                cnt++;
            }
        }
        
        return cnt + 1;
    }

    private static void makeBoxes(int n, int w) {
        int row = boxes.length - 1;
        int column = 0;
        boolean isRight = true;

        for (int i = 1; i < n + 1; i++) {
            boxes[row][column] = i;
            if (isRight) {
                column++;
            }
            if (!isRight) {
                column--;
            }
            if (column >= w) {
                isRight = !isRight;
                column--;
                row -= 1;
            }
            if (column <= -1) {
                isRight = !isRight;
                column++;
                row -= 1;
            }
        }
    }

    private static void makeBoxesSize(int n, int w) {
        int remain = n % w;
        int row = n / w;
        if (remain > 0) {
            row += 1;
        }

        boxes = new int[row][w];
    }
}
