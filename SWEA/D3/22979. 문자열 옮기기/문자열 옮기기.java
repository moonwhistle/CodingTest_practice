import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            String given = input.next();
            int K = input.nextInt();
            long sumCommand = 0;
            for (int j = 0; j < K; j++) {
                sumCommand += input.nextInt();
            }

            int command = (int) (sumCommand % given.length());

            if (command < 0) {
                command += given.length();
            }

            String answer = given.substring(command) + given.substring(0, command);
            System.out.println(answer);
        }
    }
}
