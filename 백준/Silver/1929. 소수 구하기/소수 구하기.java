import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int M = input.nextInt();
        int N = input.nextInt();

        for (int i = M; i <= N; i++) {
            boolean isDecimal = false;
            if(i == 1) {
                continue;
            }
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isDecimal = true;
                    break;
                }
            }
            if(!isDecimal) {
                System.out.println(i);
            }
        }
    }
}
