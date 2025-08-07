import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i : queue1) {
            q1.add(i);
            sum1 += i;
        }

        for (int i : queue2) {
            q2.add(i);
            sum2 += i;
        }

        long total = sum1 + sum2;
        if (total % 2 != 0) return -1;

        int count = 0;
        int maxCount = queue1.length * 3;

        while (count <= maxCount) {
            if (sum1 == sum2) return count;

            if (sum1 > sum2) {
                if (q1.isEmpty()) return -1;
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            } else {
                if (q2.isEmpty()) return -1;
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            }

            count++;
        }

        return -1;
    }
}
