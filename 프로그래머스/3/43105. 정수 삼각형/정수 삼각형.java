class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                        {7},
                        {3, 8},
                        {8, 1, 0},
                        {2, 7, 4, 4},
                        {4, 5, 2, 6, 5}
                }
        ));
    }

    public static int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;

        int[] dp = new int[triangle[triangle.length - 1].length];
        dp[0] = triangle[0][0];

        for (int i = 0; i < triangle.length - 1; i++) {
            int[] next = new int[triangle[i + 1].length];

            for (int j = 0; j < triangle[i].length; j++) {
                int now = dp[j];
                next[j] = Math.max(next[j], now + triangle[i + 1][j]);
                next[j + 1] = Math.max(next[j + 1], now + triangle[i + 1][j + 1]);
            }

            dp = next;
        }

        for (int i : dp) {
            answer = Math.max(i, answer);
        }

        return answer;
    }
}
