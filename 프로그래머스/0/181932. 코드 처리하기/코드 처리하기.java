class Solution {
    public String solution(String code) {
       StringBuilder answer = new StringBuilder();
        char[] codeArray = code.toCharArray();
        int mode = 1;
        for(int i=0; i<code.length();i++){
            if(codeArray[i] == '1'){
                mode *= -1;
                continue;
            }
            if(mode == 1 && i % 2 == 0){
                answer.append(codeArray[i]);
            }
            if(mode == -1 && i % 2 != 0){
                answer.append(codeArray[i]);
            }
        }
        if(answer.toString().isEmpty()){
            answer = new StringBuilder("EMPTY");
        }
        return answer.toString();
    }
}