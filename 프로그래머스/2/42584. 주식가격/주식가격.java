import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<PriceSecond> st = new Stack<>();

        for (int i = 0; i < prices.length; i++) {

            for (PriceSecond p : st) {
                p.increase();
            }

            while (!st.isEmpty() && st.peek().price() > prices[i]) {
                PriceSecond p = st.pop();
                answer[p.idx()] = p.second();
            }

            st.add(new PriceSecond(prices[i], i));
        }

        for (PriceSecond p : st) {
            answer[p.idx()] = p.second();
        }

        return answer;
    }
}

class PriceSecond {

    private final int price;
    private final int idx;
    private int second;


    PriceSecond(int price, int idx) {
        this.price = price;
        this.idx = idx;
        this.second = 0;
    }

    public int idx() {
        return this.idx;
    }

    public void increase() {
        this.second++;
    }

    public int price() {
        return this.price;
    }

    public int second() {
        return this.second;
    }
}
