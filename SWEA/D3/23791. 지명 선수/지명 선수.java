import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int test = 0; test < T; test++) {
            int N = input.nextInt();

            String[] players = new String[N + 1];
            Queue<Integer> A = new LinkedList<>();
            Queue<Integer> B = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                A.add(input.nextInt());
            }
            for (int i = 0; i < N; i++) {
                B.add(input.nextInt());
            }

            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    while (true) {
                        int element = A.poll();
                        if (players[element] == null) {
                            players[element] = "A";
                            break;
                        }
                    }
                } else {
                    while (true) {
                        int element = B.poll();
                        if (players[element] == null) {
                            players[element] = "B";
                            break;
                        }
                    }
                }
            }

            for (int i = 1; i < N + 1; i++) {
                System.out.print(players[i]);
            }
            System.out.println();
        }
    }
}
