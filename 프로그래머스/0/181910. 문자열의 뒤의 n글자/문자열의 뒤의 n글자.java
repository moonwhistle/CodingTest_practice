class Solution {
    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();
        char[] chars = my_string.toCharArray();
        for (int i = my_string.length() - n; i < my_string.length() ; i++) {
            answer.append(chars[i]);
        }
        return answer.toString();
    }
}