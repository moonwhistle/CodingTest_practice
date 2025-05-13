import java.util.ArrayList;
import java.util.List;

class Solution {

    // 원래 로또 맞은 개수 계산
    // 0 의 개수 계산
    // 최저, 최대 계산

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        List<Integer> lottoNumber = new ArrayList<>();
        for (int lotto : lottos) {
            lottoNumber.add(lotto);
        }

        int originalWinNumber = originalWinNumber(lottoNumber, win_nums);
        int zero = countZero(lottoNumber);

        int min = originalWinNumber;
        int max = originalWinNumber + zero;

        answer[0] = Prize.findPrize(max);
        answer[1] = Prize.findPrize(min);
        
        return answer;
    }

    public static int originalWinNumber(List<Integer> lotto, int[] win_nums) {
        int cnt = 0;
        for (int win_num : win_nums) {
            if (lotto.contains(win_num)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int countZero(List<Integer> lotto) {
        int cnt = 0;
        for (int num : lotto) {
            if (num == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public enum Prize {

        FIRST(1, 6),
        SECOND(2, 5),
        THIRD(3, 4),
        FORTH(4, 3),
        FIFTH(5, 2);

        private final int prize;
        private final int winNumber;

        Prize(int prize, int winNumber) {
            this.prize = prize;
            this.winNumber = winNumber;
        }

        public static int findPrize(int winning) {
            for (Prize win : Prize.values()) {
                if (win.winNumber == winning) {
                    return win.prize;
                }
            }

            return 6;
        }
    }
}
