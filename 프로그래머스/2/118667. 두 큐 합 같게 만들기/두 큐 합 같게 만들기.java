import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // 문제의 핵심은 한 쪽만 그 합의 반을 맞추면 될 것 같음
    // 다만 신경써야 할 부분은 얼마나 루프를 돌려야 하는지
    // 최대 루프 횟수는 두 큐 길이의 합

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        long target = (sum1 + sum2) / 2;

        int maxCount = queue1.length * 3;

        while (answer <= maxCount) {
            if (sum1 == target) {
                break;
            }

            if (sum1 > target) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            } else {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.offer(num);
            }

            answer++;
        }

        return sum1 == target ? answer : -1;
    }
}
