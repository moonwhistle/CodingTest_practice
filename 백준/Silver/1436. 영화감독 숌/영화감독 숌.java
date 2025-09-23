import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        int cnt = 1;
        int num = 666;

        while(cnt != N) {
            num++;

            String number = String.valueOf(num);

            if(number.contains("666")) {
                cnt++;
            }
        }

        System.out.println(num);
    }
}
