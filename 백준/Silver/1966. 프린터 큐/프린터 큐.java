import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int M = input.nextInt();

            List<Integer> scores = new ArrayList<>();
            Queue<Number> numbers = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                int score = input.nextInt();

                scores.add(score);

                if (j == M) {
                    numbers.add(new Number(true, score));
                } else {
                    numbers.add(new Number(false, score));
                }
            }

            Collections.sort(scores);

            int cnt = 0;
            while (!numbers.isEmpty()) {
                if (numbers.peek().score == scores.get(scores.size() - 1)) {
                    Number number = numbers.poll();
                    scores.remove(scores.size() - 1);
                    cnt++;

                    if (number.isTarget) {
                        System.out.println(cnt);
                    }
                } else {
                    Number number = numbers.poll();
                    numbers.add(number);
                }
            }
        }

    }
}

class Number {

    boolean isTarget;
    int score;

    public Number(boolean isTarget, int score) {
        this.isTarget = isTarget;
        this.score = score;
    }
}
