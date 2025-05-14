import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;
        int N = input.nextInt();
        String M = input.next();

        for(int i = 0; i<M.length(); i++) {
            sum += Integer.parseInt(String.valueOf(M.charAt(i)));
        }

        System.out.println(sum);
    }
}
