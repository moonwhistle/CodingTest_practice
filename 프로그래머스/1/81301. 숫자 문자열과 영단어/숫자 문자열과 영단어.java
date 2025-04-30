import java.util.Objects;

class Solution {
    static StringBuilder numberString = new StringBuilder();

    public static int solution(String s) {
        changeStringToNumber(s);
        return Integer.parseInt(numberString.toString());
    }

    private static void changeStringToNumber(String s) {
        StringBuilder builder = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) { // 숫자일 경우
                numberString.append(c);
                builder.setLength(0);
                continue;
            }

            builder.append(c);

            if(builder.length() != 0) { // 문자열이 들어있을 경우
                int num = Number.getNumber(builder.toString());
                if(num != -1) {
                    numberString.append(num);
                    builder.setLength(0);
                }
            }
        }
    }

    public enum Number {

        ZERO(0, "zero"),
        ONE(1, "one"),
        TWO(2, "two"),
        THREE(3, "three"),
        FOUR(4, "four"),
        FIVE(5, "five"),
        SIX(6, "six"),
        SEVEN(7, "seven"),
        EIGHT(8, "eight"),
        NINE(9, "nine");

        private final int number;
        private final String word;

        Number(int number, String word) {
            this.number = number;
            this.word = word;
        }

        public static int getNumber(String word) {
            for (Number n : Number.values()) {
                if (Objects.equals(n.word, word)) {
                    return n.number;
                }
            }

            return -1;
        }
    }
}