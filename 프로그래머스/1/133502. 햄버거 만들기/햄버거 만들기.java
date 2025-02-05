import java.util.Stack;

class Solution {

    static int answer = 0;

    public static int solution(int[] ingredient) {
        answer = 0;
        Stack<Integer> order = new Stack<>();

        for(int i = 0; i<ingredient.length; i++) {
            order.add(ingredient[i]);

            if(order.size() >= 4) {
                checkHamburger(order);
            }
        }

        System.out.println(answer);
        return answer;
    }

    private static void checkHamburger(Stack<Integer> order) {
        int first = order.pop();
        int second = order.pop();
        int third = order.pop();
        int fourth = order.pop();

        if(first == 1 && second == 3 && third == 2 && fourth == 1) {
            answer++;
        } else {
            order.add(fourth);
            order.add(third);
            order.add(second);
            order.add(first);
        }
    }
}
