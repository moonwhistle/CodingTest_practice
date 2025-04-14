import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] snack;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int M = input.nextInt();
        int N = input.nextInt();
        snack = new int[N];

        int max = Integer.MIN_VALUE;
        int min = 1;

        for (int i = 0; i < N; i++) {
            snack[i] = input.nextInt();
            max = Math.max(snack[i], max);
        }

        List<Integer> result = new ArrayList<>();

        while (min <= max) {
            int mid = (min + max) / 2;

            int count = 0;
            for(int i = 0; i<N; i++) {
                count += snack[i] / mid;
            }

            if(count >= M) {
                result.add(mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        if(result.isEmpty()) {
            System.out.println(0);
        } else {
            Collections.sort(result);
            System.out.println(result.get(result.size()-1));
        }
    }
}
