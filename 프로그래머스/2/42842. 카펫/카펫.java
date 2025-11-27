class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 1; i<= yellow; i++) {
            if(yellow % i != 0) {
                continue;
            }

            int col = i;
            int row = yellow / i;
            int squareCount = (col + 2) * 2 + row * 2;

            if(squareCount == brown) {
                answer[0] = row + 2;
                answer[1] = col + 2;
                break;
            }
        }

        return answer;
    }
}
