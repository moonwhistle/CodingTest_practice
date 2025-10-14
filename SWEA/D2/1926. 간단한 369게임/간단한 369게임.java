import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        for (int i = 1; i <= N; i++) {
            boolean isThree = false;
            String bar = "";
            String[] repeat = String.valueOf(i).split("");

            for (String element : repeat) {
                if (Objects.equals(element, "0")) {
                    continue;
                }

                if (Integer.parseInt(element) % 3 == 0) {
                    bar += "-";
                    isThree = true;
                }
            }

            if (isThree) {
                System.out.print(bar + " ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
