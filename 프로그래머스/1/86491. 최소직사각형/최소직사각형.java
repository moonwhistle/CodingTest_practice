class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int col = 0;
        int row = 0;

        for (int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);

            col = Math.max(col, max);
            row = Math.max(row, min);
        }

        answer = col * row;
        return answer;
    }
}
