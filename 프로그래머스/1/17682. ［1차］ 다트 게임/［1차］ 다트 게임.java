import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {

    static Map<Character, Integer> powMap = Map.of(
            'S', 1,
            'D', 2,
            'T', 3
    );

    static Map<Character, Integer> optionMap = Map.of(
            '*', 2,
            '#', -1
    );

    public int solution(String dartResult) {
        int answer = 0;
        int cnt = 0;
        List<Dart> darts = new ArrayList<>();
        String number = "";

        for (char dartElement : dartResult.toCharArray()) {
            if (dartElement >= 48 && dartElement <= 57) {
                number += String.valueOf(dartElement);
            } else if (dartElement >= 65 && dartElement <= 90) {
                darts.add(new Dart(Integer.parseInt(number), powMap.get(dartElement)));
                cnt++;
                number = "";
            } else if (dartElement == '*') {
                if (cnt - 1 >= 0) {
                    darts.get(cnt - 1)
                            .changeOption(optionMap.get(dartElement));
                }

                if (cnt - 2 >= 0) {
                    darts.get(cnt - 2)
                            .changeOption(optionMap.get(dartElement));
                }
            } else {
                if (cnt - 1 >= 0) {
                    darts.get(cnt - 1)
                            .changeOption(optionMap.get(dartElement));
                }
            }
        }

        for (Dart dart : darts) {
            answer += dart.result();
        }

        return answer;
    }
}

class Dart {

    private final int num;
    private final int pow;
    private int option;

    public Dart(int num, int pow) {
        this.num = num;
        this.pow = pow;
        this.option = 1;
    }

    public int result() {
        return (int) (Math.pow(num, pow) * option);
    }

    public void changeOption(int option) {
        this.option *= option;
    }
}
