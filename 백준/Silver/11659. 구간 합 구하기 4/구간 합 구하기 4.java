import java.util.Scanner;

public class Main {

    static int[] sum;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        sum = new int[N + 1];

        // sum 배열 만들기
        for (int i = 1; i < N + 1; i++) {
            if (i == 1) {
                sum[i] = input.nextInt();
                continue;
            }

            sum[i] = sum[i - 1] + input.nextInt();
        }

        // i,j 입력받고 구간 합 출력하기
        for (int c = 0; c < M; c++) {
            // i, j 입력받기
            int i = input.nextInt();
            int j = input.nextInt();

            // 구간 합 출력하기
            System.out.println(sum[j] - sum[i - 1]);
        }
    }
}
