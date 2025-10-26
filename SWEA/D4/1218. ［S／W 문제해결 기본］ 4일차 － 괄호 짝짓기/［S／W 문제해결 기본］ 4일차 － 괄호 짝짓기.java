import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int size = input.nextInt();
            String line = input.next();

            boolean isGood = true;
            Stack<Character> elements = new Stack<>();

            for (int j = 0; j < size; j++) {
                char element = line.charAt(j);

                if (element == '}') {
                    if (elements.peek() == '{') {
                        elements.pop();
                    } else {
                        isGood = false;
                        break;
                    }
                } else if (element == ')') {
                    if (elements.peek() == '(') {
                        elements.pop();
                    } else {
                        isGood = false;
                        break;
                    }
                } else if (element == '>') {
                    if (elements.peek() == '<') {
                        elements.pop();
                    } else {
                        isGood = false;
                        break;
                    }
                } else if (element == ']') {
                    if (elements.peek() == '[') {
                        elements.pop();
                    } else {
                        isGood = false;
                        break;
                    }
                } else {
                    elements.push(element);
                }
            }

            if (isGood) {
                System.out.println("#" + i + " " + 1);
            } else {
                System.out.println("#" + i + " " + 0);
            }
        }
    }
}
