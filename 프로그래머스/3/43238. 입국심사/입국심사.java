import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long start = 1;
        long end = n * (long)times[times.length -1];
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            
            for(int time : times) {
                cnt += (mid / time);
            }
            
            if(cnt >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}