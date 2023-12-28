class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        int i = 0;
        int j = 0;
        for (int k = 0; k < goal.length; k++) {
            if (i < cards1.length && goal[k].equals(cards1[i])) {
                i++;
            } else if (j < cards2.length && goal[k].equals(cards2[j])) {
                j++;
            } else {
                // cards1[i]나 cards2[j] 중 어느 것도 goal[k]와 일치하지 않는 경우
                answer = "No";
                break;
            }
        }

        // goal의 모든 요소가 일치하는지 확인
        if (i + j == goal.length) {
            answer = "Yes";
        }

        return answer;
    }
}