class Solution {

    public static void main(String[] args) {
        solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};

        answer = makeMap(n, arr1, arr2); // 지도 만들기

        return answer;
    }

    private static String[] makeMap(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            int calculatedNumber = arr1[i] | arr2[i]; // or 연산
            map[i] = makeLine(calculatedNumber, n);
        }

        return map;
    }

    private static String makeLine(int number, int n) {
        String mapLine = "";
        int num = number;

        for (int i = n - 1; i >= 0; i--) {
            int pow = (int) Math.pow(2, i); // 2의 제곱

            if (num - pow >= 0) {
                mapLine += "#";
                num -= pow;
            } else {
                mapLine += " ";
            }
        }

        return mapLine;
    }
}
