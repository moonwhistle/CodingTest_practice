import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            String line = input.next();
            String y = line.substring(0, 4);
            String m = line.substring(4, 6);
            String d = line.substring(6, 8);

            if (isValidDate(Integer.parseInt(m), Integer.parseInt(d))) {
                System.out.println("#" + i + " " + y + "/" + m + "/" + d);
            } else {
                System.out.println("#" + i + " " + -1);
            }
        }
    }

    public static boolean isValidDate(int month, int day) {
        int[] daysInMonth = {
                0,  // index 0은 사용하지 않음 (1월부터 시작)
                31, // 1월
                28, // 2월 (윤년은 고려하지 않음)
                31, // 3월
                30, // 4월
                31, // 5월
                30, // 6월
                31, // 7월
                31, // 8월
                30, // 9월
                31, // 10월
                30, // 11월
                31  // 12월
        };

        return day >= 1 && day <= daysInMonth[month];
    }
}
