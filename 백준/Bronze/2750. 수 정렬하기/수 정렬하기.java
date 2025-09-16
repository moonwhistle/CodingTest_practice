import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = input.nextInt();
        }

        Arrays.sort(array);
        
        for (int i = 0; i < N; i++) {
            System.out.println(array[i]);
        }
    }
}
