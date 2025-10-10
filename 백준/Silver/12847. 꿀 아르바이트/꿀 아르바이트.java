import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // setting
        int n = input.nextInt();
        int m = input.nextInt();
        int[] money = new int[n];
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            money[i] = input.nextInt();
        }

        // 처음 m 일 계산
        long sum = 0;

        for(int i = 0 ; i<m ; i++) {
            sum += money[i];
        }

        max = sum;

        // 이후의 m 일 계산하며 계속 업데이트 쳐줌
        for(int i = m; i<n; i++) {
            sum -= money[i-m];
            sum += money[i];

            max = Math.max(max, sum);
        }

        // sout
        System.out.println(max);
    }
}
