import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int K = input.nextInt();

        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = input.nextInt();
        }

        int money = K;
        int count = 0;

        for(int i = N-1; i>=0; i--) {
            if(coin[i] <= money) {
                count += money / coin[i];
                money = money % coin[i];
            }
        }


        System.out.println(count);
    }
}
