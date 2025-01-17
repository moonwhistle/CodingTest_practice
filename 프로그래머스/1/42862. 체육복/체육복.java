import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {

    public static int solution(int n, int[] lost, int[] reserve) {
       // 도난당한 학생과 여벌 체육복을 가진 학생을 각각 Set으로 저장
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);

        // 교집합(여벌이 있으면서 도난당한 학생) 처리
        Set<Integer> intersection = new HashSet<>(lostSet);
        intersection.retainAll(reserveSet); // 교집합 계산
        lostSet.removeAll(intersection);   // 도난당한 리스트에서 제거
        reserveSet.removeAll(intersection);// 여벌 리스트에서 제거

        // 체육복 빌려주기
        for (int r : reserveSet) {
            if (lostSet.contains(r - 1)) {   // 앞 번호 학생에게 빌려줌
                lostSet.remove(r - 1);
            } else if (lostSet.contains(r + 1)) { // 뒷 번호 학생에게 빌려줌
                lostSet.remove(r + 1);
            }
        }

        // 체육복을 가진 학생의 수 계산
        return n - lostSet.size();
    }
}
