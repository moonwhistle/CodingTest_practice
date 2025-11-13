import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i < 11; i++) {
            int size = input.nextInt();
            String line = input.next();
            boolean isSame = true;

            while (isSame) {
                isSame = false;

                for (int j = 1; j < line.length(); j++) {
                    if (line.charAt(j - 1) == line.charAt(j)) {
                        String leftPart = line.substring(0, j - 1);
                        String rightPart = line.substring(j + 1);
                        line = leftPart + rightPart;
                        isSame = true;
                        break;
                    }
                }
            }

            System.out.println("#" + i + " " + line);
        }
    }
}
