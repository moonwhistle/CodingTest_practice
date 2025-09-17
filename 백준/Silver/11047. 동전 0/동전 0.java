import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int K = input.nextInt();

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = input.nextInt();
        }

        // 뒤에서부터 내려오며 계산
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            count += K / coins[i];
            K %= coins[i];
        }

        System.out.println(count);
    }
}
