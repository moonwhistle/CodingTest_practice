import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            int possible = (M+1) / 2;
            System.out.println(Math.min(4, possible));
        } else {
            if(M < 7) {
                System.out.println(Math.min(4, M));
            } else {
                int add = M-6;
                System.out.println(add + 4);
            }
        }
    }
}
