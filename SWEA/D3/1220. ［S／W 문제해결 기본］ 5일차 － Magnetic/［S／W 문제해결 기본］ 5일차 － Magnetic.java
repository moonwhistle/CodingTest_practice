import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int T = 0; T < 10; T++) {
            // setting
            int row = input.nextInt();
            int[][] map = new int[row][row];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    map[i][j] = input.nextInt();
                }
            }

            int count = 0;

            // 세로로 돌면서 stack 에 값을 담음
            // stack 들어있는 값과 들어오려는 값을 비교
            for (int x = 0; x < row; x++) {
                int last = 0;

                for (int y = 0; y < row; y++) {
                    if (map[y][x] == 0) {
                        continue;
                    }

                    if (last == 1 && map[y][x] == 2) {
                        count++;
                    }

                    last = map[y][x];
                }
            }

            System.out.println("#" + (T + 1) + " " + count);
        }
    }
}
