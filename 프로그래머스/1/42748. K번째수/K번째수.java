import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
       int[] answer = new int[commands.length];
        int count = 0;
        for (int[] command : commands) {
            int[] temp = new int[command[1] - command[0] + 1];
            System.arraycopy(array, command[0] - 1, temp, 0, command[1] - command[0] + 1);
            Arrays.sort(temp);;
            answer[count] = temp[command[2] - 1];
            count++;
        }
        return answer;
    }
}