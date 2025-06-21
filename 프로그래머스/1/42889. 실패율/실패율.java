import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {

    // stages 오름차순 정렬 후, N 까지 돌리면서 실패율 계산

    static Map<Integer, Float> failRate = new HashMap<>();

    public static List<Integer> solution(int N, int[] stages) {
        calculateFailRate(N, stages);
        System.out.println(failRate);

        return failRate.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Float>comparingByValue().reversed())
                .map(Entry::getKey)
                .collect(Collectors.toList());
    }

    private static void calculateFailRate(int N, int[] stages) {
        int[] count  = countStageCount(N, stages);
        int length = stages.length;

        for(int i = 1; i<=N; i++) {
            if (length == 0) {
                failRate.put(i, 0f);
            } else {
                failRate.put(i, (float) count[i] / length);
                length -= count[i];
            }
        }
    }

    private static int[] countStageCount(int N, int[] stages) {
        int[] count = new int[N+2];

        for(int stage : stages) {
            count[stage] ++;
        }

        return count;
    }
}
