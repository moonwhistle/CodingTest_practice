class Solution {

    public static int solution(String s) {
        int answer = 0;
        //세팅
        String x = "";
        int xCount = 0;
        int yCount = 0;

        //전체 순회
        for (int i = 0; i < s.length(); i++) {
            if (xCount == 0) {
                x = s.substring(i, i + 1);
                xCount++;
            } else if (x.equals(s.substring(i, i + 1))) {
                xCount++;
            } else {
                yCount++;
            }

            if (xCount == yCount) {
                answer++;
                xCount = 0;
                yCount = 0;
            }

            if (xCount != 0 && i == s.length() - 1) {
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }
}
