class Solution {

    // 누적합 전파

    static int[][] sum;

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        sum = new int[board.length + 1][board[0].length + 1];

        setSumNumber(skill);
        propagateRow();
        propagateColumn();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

    private static void propagateRow() {
        for (int i = 0; i < sum.length; i++) {
            for (int j = 1; j < sum[i].length; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
    }

    private static void propagateColumn() {
        for (int i = 0; i < sum[0].length; i++) {
            for (int j = 1; j < sum.length; j++) {
                sum[j][i] += sum[j - 1][i];
            }
        }
    }

    private static void setSumNumber(int[][] skill) {
        for (int[] skillElement : skill) { // 스킬 반복 사용
            // 좌표
            int startX = skillElement[2];
            int lastX = skillElement[4] + 1;
            int startY = skillElement[1];
            int lastY = skillElement[3] + 1;

            // 힐 or 어택 카운트
            int healAttackCount = healOrAttackCount(skillElement[0], skillElement[5]);

            // 누적합 세팅
            sum[startY][startX] += healAttackCount;
            sum[lastY][startX] -= healAttackCount;
            sum[startY][lastX] -= healAttackCount;
            sum[lastY][lastX] += healAttackCount;
        }
    }

    private static int healOrAttackCount(int delimiter, int count) {
        if (delimiter == 1) {
            return -count;
        } else {
            return count;
        }
    }
}
