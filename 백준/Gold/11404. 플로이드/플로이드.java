import java.util.Scanner;

public class Main {

    private static final int MAX_NUMBER = Integer.MAX_VALUE;

    private static long[][] city;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        //세팅
        city = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    city[i][j] = 0;
                } else {
                    city[i][j] = MAX_NUMBER;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int start = input.nextInt() - 1;
            int end = input.nextInt() - 1;
            int weight = input.nextInt();
            city[start][end] = Math.min(city[start][end], weight);
        }

        //플로이드-워셜 알고리즘
        for (int k = 0; k < n; k++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    city[s][e] = Math.min(city[s][e], city[s][k] + city[k][e]);
                }
            }
        }

        //출력
        for(long[] nums : city) {
            for(long num : nums) {
                if(num == MAX_NUMBER) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
    }
}
