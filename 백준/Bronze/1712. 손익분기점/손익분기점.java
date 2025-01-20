import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();
        int a = getBreakEvenPoint(A, B, C);
        System.out.println(a);


    }

    private static int getBreakEvenPoint(int A, int B, int C) {
        if (B >= C) {
            return -1;
        }

        long standard = A;
        long sell = 0;
        int count = 0;

        while (standard >= sell) {
            count++;
            standard += B;
            sell += C;
        }

        return count;
    }
}
