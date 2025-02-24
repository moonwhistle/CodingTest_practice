import java.util.HashMap;
import java.util.Map;

class Solution {

    static Map<Integer, Integer> choicePoint = Map.of(1, 3, 2, 2, 3, 1, 4, 0, 5, 1, 6, 2, 7, 3);

    public static void main(String[] args) {
        solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        // 세팅
        Map<String, Integer> statistics = new HashMap<>();

        // 점수에 따라 성격 유형 구분
        for(int i = 0; i<survey.length; i++) {
            String surveyElement = survey[i];
            int choice = choices[i];

            if(choice > 4) {
                String word = String.valueOf(surveyElement.charAt(1));
                statistics.put(word, statistics.getOrDefault(word, 0) + choicePoint.get(choice));
            } else if (choice < 4) {
                String word = String.valueOf(surveyElement.charAt(0));
                statistics.put(word, statistics.getOrDefault(word, 0) + choicePoint.get(choice));
            }
        }

        // 통계값에 따라 정답 도출
        int r = getValue("R", statistics);
        int t = getValue("T", statistics);
        int c = getValue("C", statistics);
        int f = getValue("F", statistics);
        int j = getValue("J", statistics);
        int m = getValue("M", statistics);
        int a = getValue("A", statistics);
        int n = getValue("N", statistics);

        if(r < t) {
            answer += "T";
        } else {
            answer += "R";
        }

        if(f > c) {
            answer += "F";
        } else {
            answer += "C";
        }

        if(m > j) {
            answer += "M";
        } else {
            answer += "J";
        }

        if(n > a) {
            answer += "N";
        } else {
            answer += "A";
        }

        System.out.println(answer);
        return answer;
    }

    private static int getValue(String word, Map<String, Integer> statistics) {
        if(statistics.containsKey(word)) {
            return statistics.get(word);
        }
        return 0;
    }
}
