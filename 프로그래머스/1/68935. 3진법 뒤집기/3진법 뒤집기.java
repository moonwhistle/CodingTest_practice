import java.util.ArrayList;
import java.util.List;

class Solution {

    // 10진법 -> 3진법 바꾸기
    // 자리 바꾸기
    // 3진법 -> 10진법

    public static int solution(int n) {

        return changeTernaryToDecimal(changeDecimalToReverseTernary(n));
    }

    private static List<Integer> changeDecimalToReverseTernary(int n) {
        // 세팅
        List<Integer> reverseTernary = new ArrayList<>();

        int share = n / 3;
        int mod = n % 3;
        reverseTernary.add(mod);

        // 로직
        while (share != 0) {
            mod = share % 3;
            share /= 3;
            reverseTernary.add(mod);
        }

        return reverseTernary;
    }

    private static int changeTernaryToDecimal(List<Integer> reverseTernary) {
        int size = reverseTernary.size() - 1; // 제곱수
        int decimal = 0; // 10진수
        int j = 0; // 숫자 가져오는 인덱스

        for(int i = size; i>=0; i--) {
            decimal += (int) Math.pow(3, i) * reverseTernary.get(j);
            j++;
        }

        return decimal;
    }
}
