class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < my_strings.length; i++) {
            char[] my_char = my_strings[i].toCharArray();
            int[] part = parts[i];
            for(int j = part[0]; j < part[1] + 1; j++) {
                answer.append(my_char[j]);
            }
        }
        return answer.toString();
    }
}