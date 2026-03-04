import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        dp();
        
        if(dp[n-1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n-1]);
        }
    }

    private static void dp() {
        dp[0] = 0;

        for(int i = 0 ; i < n ; i++) {
            int now = dp[i];

            for(int j = i + 1; j < Math.min(i + 1 + arr[i], n); j++) {
                dp[j] = Math.min(dp[j], now + 1);
            }
        }
    }
}
