class Solution {
    public String solution(String str1, String str2) {
         StringBuilder answer = new StringBuilder();
        char[] str11 = str1.toCharArray();
        char[] str22 = str2.toCharArray();

        for(int i=0; i< str11.length; i++){
            answer.append(str11[i]);
            answer.append(str22[i]);
        }

        return answer.toString();
    }
}