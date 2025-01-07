import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int M = input.nextInt();
        int N = input.nextInt();

        for (int i = M; i <= N; i++) {
            if(i == 0 || i ==1) {
                continue;
            }

            if (decimal(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean decimal(int X) {
        int count = 0;

        for (int i = 2; i <= Math.sqrt(X); i++) {
            if (X % i == 0) {
                count++;
            }
        }

        return count == 0;
    }
}
