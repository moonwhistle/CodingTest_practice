import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        int[] elements = new int[N];

        for (int i = 0; i < N; i++) {
            elements[i] = input.nextInt();
        }

        Arrays.sort(elements);

        int start = 0;
        int last = N - 1;
        int cnt = 0;

        while (start < last) {
            int sum = elements[start] + elements[last];

            if(sum > M) {
                last--;
            } else if(sum < M) {
                start++;
            } else {
                cnt++;
                start++;
            }
        }

        System.out.println(cnt);
    }
}
