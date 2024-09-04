import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> category = new HashSet<>();
        for (int num : nums) {
            category.add(num);
        }
        if (nums.length / 2 < category.size()) {
            answer = nums.length / 2;
        }
        if (nums.length / 2 >= category.size()) {
            answer = category.size();
        }
        return answer;
    }
}