import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static ArrayList<Constraint> constrains = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();

        dp = new int[N + 1];
        for (int i = 1; i < M + 1; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            Constraint constraint = new Constraint(start, end);
            constrains.add(constraint);
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N + 1; i++) {

            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (!isRestrict(i)) {
                continue;
            }

            if (i + A <= N && isRestrict(i + A)) {
                dp[i + A] = Math.min(dp[i + A], dp[i] + 1);
            }

            if (i + B <= N && isRestrict(i + B)) {
                dp[i + B] = Math.min(dp[i + B], dp[i] + 1);
            }
        }

        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }

    private static boolean isRestrict(int value) {
        for (Constraint constraint : constrains) {
            if (constraint.start() <= value && value <= constraint.end()) {
                return false; 
            }
        }
        return true;
    }

    static class Constraint {
        private final int start;
        private final int end;

        Constraint(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int start() {
            return start;
        }

        public int end() {
            return end;
        }
    }
}
