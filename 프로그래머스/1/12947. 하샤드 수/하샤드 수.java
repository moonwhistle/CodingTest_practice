class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int partSum = 0;
        
        for(char xElement : String.valueOf(x).toCharArray()) {
            partSum += xElement - '0';
        }
        
        if(x % partSum == 0) {
            return answer;
        }
        
        return !answer;
    }
}
