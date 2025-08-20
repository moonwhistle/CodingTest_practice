import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int solution(int[] nums) {
        int answer = 0;
        int select = nums.length / 2;
        Map<Integer, Integer> poketmons = new HashMap<>();

        for(int i : nums) {
            poketmons.put(i, poketmons.getOrDefault(i, 0) + 1);
        }

        if(poketmons.size() >= select) {
            answer = select;
        } else {
            answer = poketmons.size();
        }

        return answer;
    }
}
