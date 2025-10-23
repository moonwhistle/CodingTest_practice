import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int P = input.nextInt();
            long sum = 0;
            boolean isBomb = false;

            for (int j = 1; j < N + 1; j++) {
                if (sum + j == P) {
                    isBomb = true;
                }

                sum += j;
            }

            if (isBomb) {
                System.out.println(sum - 1);
            } else {
                System.out.println(sum);
            }
        }
    }
}
