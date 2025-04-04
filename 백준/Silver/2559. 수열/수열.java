import java.util.Scanner;

public class Main {

    static int[] numbers;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int K = input.nextInt();

        // 세팅
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = input.nextInt();
        }

        // K일의 온도의 합
        for (int i = 0; i < N - K + 1; i++) { // 처음 값
            int sum = 0;
            for (int j = i; j < K + i; j++) { // K일 까지의 값
                sum += numbers[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
