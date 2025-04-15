import java.util.Scanner;

public class Main {

    static int[] wines;
    static int[] dp;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        // 세팅
        wines = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wines[i] = input.nextInt();
        }

        dp[1] = wines[1];
        if (n >= 2) {
            dp[2] = dp[1] + wines[2];
        }

        for (int i = 3; i <= n; i++) { // 1,2 / 1,3 / 2,3
            dp[i] = Math.max(
                    dp[i-1] , Math.max(
                            dp[i-2] + wines[i], dp[i -3] + wines[i-1] + wines[i]
                    )
            );
        }

        System.out.println(dp[n]);

    }
}
