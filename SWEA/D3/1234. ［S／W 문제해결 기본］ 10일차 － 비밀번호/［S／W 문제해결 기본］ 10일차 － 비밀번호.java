import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i < 11; i++) {
            int size = input.nextInt();
            String line = input.next();
            char[] lineArr = line.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char lineElement : lineArr) {
                if (stack.empty()) {
                    stack.add(lineElement);
                } else {
                    if (stack.peek() == lineElement) {
                        stack.pop();
                    } else {
                        stack.add(lineElement);
                    }
                }
            }

            String answer = "";

            for (char stackElement : stack) {
                answer += stackElement;
            }

            System.out.println("#" + i + " " + answer);
        }
    }
}
