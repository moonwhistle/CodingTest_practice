class Solution {
    public int solution(int n, String control) {
        int answer = n;
        for(char al : control.toCharArray()){
            if(al == 'w'){
                answer += 1;
            }
            if(al == 's'){
                answer -= 1;
            }
            if(al == 'd'){
                answer += 10;
            }
            if(al == 'a'){
                answer -= 10;
            }
        }
        return answer;
    }
}