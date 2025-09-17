import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = Integer.parseInt(input.nextLine());

        for (int i = 0; i < N; i++) {
            String command = input.nextLine();
            String[] commandArr = command.split(" ");

            if (Objects.equals(commandArr[0], "push")) {
                push(Integer.parseInt(commandArr[1]));
            }
            if (Objects.equals(commandArr[0], "pop")) {
                pop();
            }
            if (Objects.equals(commandArr[0], "size")) {
                size();
            }
            if (Objects.equals(commandArr[0], "empty")) {
                empty();
            }
            if (Objects.equals(commandArr[0], "top")) {
                top();
            }
        }
    }

    public static void push(int num) {
        st.push(num);
    }

    public static void pop() {
        if (st.empty()) {
            System.out.println(-1);
        } else {
            System.out.println(st.pop());
        }
    }

    public static void size() {
        System.out.println(st.size());
    }

    public static void empty() {
        if (st.empty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void top() {
        if (st.empty()) {
            System.out.println(-1);
        } else {
            System.out.println(st.peek());
        }
    }
}

