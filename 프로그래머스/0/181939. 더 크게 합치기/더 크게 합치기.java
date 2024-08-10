class Solution {
    public int solution(int a, int b) {
        int first = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int second = Integer.parseInt(Integer.toString(b) + Integer.toString(a));
        return Math.max(first, second);
    }
}