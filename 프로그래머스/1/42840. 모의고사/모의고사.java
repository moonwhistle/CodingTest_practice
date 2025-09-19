import java.util.ArrayList;
import java.util.List;

class Solution {

    static int[] first = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
    static int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    static int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        if (answers.length == 0) {
            return new int[]{1, 2, 3};
        }

        int idx = 0;
        int[] count = new int[3];
        while (idx != answers.length) {
            if (first[idx % 10] == answers[idx]) {
                count[0]++;
            }
            if (second[idx % 8] == answers[idx]) {
                count[1]++;
            }
            if (third[idx % 10] == answers[idx]) {
                count[2]++;
            }

            idx++;
        }

        int max = Math.max(count[0], Math.max(count[1], count[2]));
        List<Integer> maxMember = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                maxMember.add(i + 1);
            }
        }
        return maxMember.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
