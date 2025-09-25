import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // setting
        Set<Integer> losts = new HashSet<>();
        Set<Integer> reserves = new HashSet<>();

        for (int i : reserve) {
            reserves.add(i);
        }

        // 겹치는 부분 제거
        for (int i : lost) {
            if (reserves.contains(i)) {
                reserves.remove(i);
            } else {
                losts.add(i);
            }
        }

        // 빌려주기
        for (int i : reserves) {
            if (losts.contains(i - 1)) {
                losts.remove(i - 1);
            } else if (losts.contains(i + 1)) {
                losts.remove(i + 1);
            }
        }

        answer = n - losts.size();
        
        return answer;
    }
}
