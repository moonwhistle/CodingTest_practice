import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] arr = new int[N];

        for(int i = 0 ; i<N; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);

        int previous = 0;
        int sum = 0;

        for(int i = 0; i< arr.length; i++) {
            sum += previous + arr[i];
            previous += arr[i];
        }

        System.out.println(sum);
    }
}
