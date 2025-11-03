import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = input.nextInt();
        }

        int cnt = 0;
        int sum = 0;
        int lastIdx = 0;
        int startIdx = 0;

        while (true) {
            if (sum >= M) {
                sum -= A[startIdx];
                startIdx++;
            } else if (lastIdx == N) {
                break;
            } else {
                sum += A[lastIdx];
                lastIdx++;
            }

            if (sum == M) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
