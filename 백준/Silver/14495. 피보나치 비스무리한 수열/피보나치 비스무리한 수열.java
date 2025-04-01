import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        long[] array = new long[117];
        array[1] = 1;
        array[2] = 1;
        array[3] = 1;

        for (int i = 4; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 3];
        }

        System.out.println(array[n]);
    }
}
