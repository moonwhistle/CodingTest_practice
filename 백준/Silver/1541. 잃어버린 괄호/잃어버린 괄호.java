import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String given = input.next();

        String[] givenList = given.split("-");

        int sum = 0;

        for (int i = 0; i < givenList.length; i++) {
            String[] numbers = givenList[i].split("\\+");

            if(i == 0) {
                for(String num : numbers) {
                    sum += Integer.parseInt(num);
                }
            } else {
                for(String num : numbers) {
                    sum -= Integer.parseInt(num);
                }
            }
        }

        System.out.println(sum);
    }
}
