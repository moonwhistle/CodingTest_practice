import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // (s[j] - s[i]) % M = 0;
    // s[j] % M = s[i] % M;
    // 따라서 나머지 같은 것들 끼리 묶어주면 된다.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        long answer = 0;

        long[] sum = new long[N + 1];
        long[] remainders = new long[N + 1];
        long[] cnt = new long[M];

        for (int i = 1; i < N + 1; i++) {
            sum[i] = input.nextInt() + sum[i - 1];
            remainders[i] = sum[i] % M;
            if (remainders[i] == 0) {
                answer++;
            }

            cnt[(int) remainders[i]]++;
        }

        for (long i : cnt) {
            if (i > 1) {
                answer += i * (i - 1) / 2;
            }
        }

        System.out.println(answer);
    }
}
