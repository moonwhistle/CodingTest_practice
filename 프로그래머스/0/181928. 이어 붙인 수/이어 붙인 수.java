class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        for(int num : num_list){
            if(num % 2 == 0){
                even.append(num);
            }
            else {
                odd.append(num);
            }
        }
        answer = Integer.parseInt(String.valueOf(odd)) + Integer.parseInt(String.valueOf(even));
        return answer;
    }
}