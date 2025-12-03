class Solution {

    public static int solution(String name) {
        int answer = 0;

        for (char nameElement : name.toCharArray()) {
            answer += selectWord('A', nameElement);
        }

        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;

            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            int rightLeft = i * 2 + (name.length() - next);
            int leftRight = (name.length() - next) * 2 + i;

            move = Math.min(move, Math.min(rightLeft, leftRight));
        }

        answer += move;

        return answer;
    }

    private static int selectWord(char now, char target) {
        int first = target - now;
        int second = 26 - first;

        return Math.min(first, second);
    }
}
