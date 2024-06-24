class Solution {
    public String solution(String str1, String str2) {
        StringBuilder answer = new StringBuilder();
        char[] str11 = str1.toCharArray();
        char[] str22 = str2.toCharArray();

        int i= 0;
        for(char str111: str11){
            answer.append(str111);
            answer.append(str22[i]);
            i++;
        }

        return answer.toString();
    }
}