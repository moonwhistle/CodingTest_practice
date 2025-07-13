import java.util.Arrays;

class Solution {

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d); // 오름차순으로 정렬
        int sum = 0;

        for(int dElement : d) { // d를 순회하며 budget 판단
            sum += dElement;
            answer++;
            
            if(sum > budget) {
                answer--;
                break;
            }
        }

        System.out.println(answer);

        return answer;
    }
}
