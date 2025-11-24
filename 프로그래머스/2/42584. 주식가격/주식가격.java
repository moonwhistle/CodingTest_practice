import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Point> st = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && st.peek().price > prices[i]) {
                int idx = st.pop().idx;
                answer[idx] = i - idx;
            }

            st.add(new Point(prices[i], i));
        }

        while (!st.isEmpty()) {
            int idx = st.pop().idx;
            answer[idx] = prices.length - 1 - idx;
        }

        return answer;
    }
}

class Point {

    int price;
    int idx;

    public Point(int price, int idx) {
        this.price = price;
        this.idx = idx;
    }
}
