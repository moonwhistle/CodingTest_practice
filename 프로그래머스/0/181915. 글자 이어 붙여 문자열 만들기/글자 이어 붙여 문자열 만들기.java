class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder answer = new StringBuilder();
        char[] arr = my_string.toCharArray();
        for(int index : index_list){
            answer.append(arr[index]);
        }
        return answer.toString();
    }
}