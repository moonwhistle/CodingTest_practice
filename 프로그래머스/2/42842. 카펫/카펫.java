class Solution {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 1; i<=Math.sqrt(yellow); i++) {
            if(yellow % i == 0) {
                int y = yellow / i;
                if(canMakeSquare(i, y, brown)) {
                    answer[0] = Math.max(i, y) + 2;
                    answer[1] = Math.min(i, y) + 2;
                }
            }
        }
        
        return answer;
    }

    private static boolean canMakeSquare(int x, int y, int brown) {
        int row = x * 2;
        int colum = (y + 2) * 2;
        return brown == (row + colum);
    }
}
