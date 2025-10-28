import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int length = input.nextInt();
            String line = input.next();
            String[] lineArray = line.split("");

            int sum = 0;
            for (int j = 0; j < length; j += 2) {
                sum += Integer.parseInt(lineArray[j]);
            }

            System.out.println("#" + i + " " + sum);
        }
    }
}
