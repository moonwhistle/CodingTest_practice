class Solution {
    public String solution(int[] numLog) {
        StringBuilder string = new StringBuilder();
        int index = numLog[0];
        for (int i = 1; i < numLog.length; i++) {
            if(numLog[i] - index == 1){
                string.append('w');
            }
            if(numLog[i] - index == -1){
                string.append('s');
            }
            if(numLog[i] - index == 10){
                string.append('d');
            }
            if(numLog[i] - index == -10){
                string.append('a');
            }
            index = numLog[i];
        }
        return string.toString();
    }
}