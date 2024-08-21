class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> checkBox = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for(int num : nums){
            if(!checkBox.add(num)){
                answer.add(num);
            }
        }
        return answer;
    }
}