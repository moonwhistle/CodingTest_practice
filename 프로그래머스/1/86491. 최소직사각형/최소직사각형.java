class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        //가로 세로
        int x = 0;
        int y = 0;

        for (int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);

            if (max > x) {
                x = max;
            }
            if (min > y) {
                y = min;
            }
        }

        answer = x * y;
        return answer;
    }
}