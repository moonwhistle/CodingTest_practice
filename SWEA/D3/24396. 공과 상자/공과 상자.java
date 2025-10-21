import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            int B = input.nextInt();
            int W = input.nextInt();

            int X = input.nextInt();
            int Y = input.nextInt();
            int Z = input.nextInt();

            List<Ball> balls = new ArrayList<>();
            balls.add(new Ball(B, X));
            balls.add(new Ball(W, Y));

            Collections.sort(balls);

            Ball max = balls.get(1);
            Ball min = balls.get(0);

            int[] sums = new int[min.count + 1];
            sums[0] = (max.count * max.score) + (min.count * min.score);
            int cnt = 1;

            for (int j = 1; j <= min.count; j++) {
                sums[j] = sums[j - 1] - (max.score * cnt) - (min.score * cnt) + (cnt * 2 * Z);
            }

            Arrays.sort(sums);

            System.out.println(sums[min.count]);
        }
    }
}

class Ball implements Comparable<Ball> {

    int count;
    int score;

    public Ball(int count, int score) {
        this.count = count;
        this.score = score;
    }

    @Override
    public int compareTo(Ball other) {
        return this.count - other.count;
    }
}
