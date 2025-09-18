import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        int[] arr = new int[N];
        for(int i = 0 ; i<N; i++) {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i< N-2 ; i++ ){
            int delimiter = arr[i];
            int target = M - delimiter;
            int start = i + 1;
            int end = N-1;

            while(start < end) {
                int sum = arr[start] + arr[end];

                if(sum <= target) {
                    max = Math.max(max, sum + delimiter);
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(max);
    }
}
