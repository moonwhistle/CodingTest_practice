import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // 문제의 핵심은 한 쪽만 그 합의 반을 맞추면 될 것 같음
    // 다만 신경써야 할 부분은 얼마나 루프를 돌려야 하는지
    // 최대 루프 횟수는 두 큐 길이의 합

    public static int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for(int n : queue1){
            q1.add(n);
            sum1 += n;
        }

        for(int n : queue2){
            q2.add(n);
            sum2 += n;
        }

        int cnt = 0;

        while(cnt <= queue1.length * 4){
            if(sum1 > sum2){
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.add(poll);
            }else if(sum1 < sum2){
                int poll = q2.poll();
                sum2 -= poll;
                sum1 += poll;
                q1.add(poll);
            }else if(sum1 == sum2){
                answer = cnt;
                break;
            }
            cnt++;
        }

        return answer;
    }
}
