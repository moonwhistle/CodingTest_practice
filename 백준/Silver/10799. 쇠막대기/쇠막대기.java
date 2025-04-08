import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int sum = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String given = input.next();
        Stack<Integer> pair = new Stack<>();

        for (int i = 0; i < given.length(); i++) {
            char part = given.charAt(i);

            if (part == '(') {
                pair.push(i);
            } else {
                pair.pop();
                if(given.charAt(i-1) == '(') {
                    sum += pair.size();
                } else {
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}
