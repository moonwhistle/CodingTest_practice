class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr.clone();
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            for (int i = s; i < e + 1; i++) {
                if(i % k == 0){
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }
}