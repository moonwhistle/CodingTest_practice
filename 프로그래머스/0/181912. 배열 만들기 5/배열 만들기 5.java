import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        for (String intStr : intStrs) {
            String str = intStr.substring(s, s+l);
            if(Integer.parseInt(str) > k){
                answer.add(Integer.parseInt(str));
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}