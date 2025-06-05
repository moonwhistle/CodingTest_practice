import java.util.HashMap;
import java.util.Map;

class Solution {

    // 기준이 되는 수의 절반을 나눠서 약수를 구함
    // 약수의 짝/홀을 판단해서 더해줌

    static Map<Integer, Integer> measureCount = new HashMap<>();

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            countMeasure(i);
        }

        for(int key : measureCount.keySet()) {
            if(measureCount.get(key) % 2 == 0) {
                answer += key;
            } else {
                answer -= key;
            }
        }

        return answer;
    }

    public static void countMeasure(int number) {
        int count = 2;
        
        if(number == 1) {
            measureCount.put(1, 1);
            return;
        }

        for (int i = 2; i <= number / 2; i++) {
            if(number % i == 0){
                count++;
            }
        }

        measureCount.put(number, count);
    }
}
