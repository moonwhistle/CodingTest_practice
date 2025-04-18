import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        int[] dp = new int[N+1];
        int mod = 1000000007;

        dp[0] = 1; // 세팅값

        for(int i = 1; i<= N; i++) {
            dp[i] = dp[i-1];

            if(M <= i) {
                dp[i] = (dp[i] + dp[i-M]) % mod;
            }
        }

        System.out.println(dp[N]);
    }
}
