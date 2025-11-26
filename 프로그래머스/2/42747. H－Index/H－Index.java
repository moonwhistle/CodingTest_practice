import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int max = citations[citations.length - 1];

        for (int i = max; i >= 0; i--) {
            int idx = citations.length - 1;
            int cnt = 0;

            while (idx >= 0) {
                if (citations[idx] < i) {
                    break;
                }

                cnt++;
                idx--;
            }

            if (cnt >= i) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
