class Solution {

    // 날짜 계산 - for 문 7번 % 8 / 6,7 은 패스
    // 늦은 날 있는지 계산
    static boolean[] people;

    public static void main(String[] args) {
        solution(new int[]{700, 800, 1100},
                new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809},
                        {1105, 1001, 1002, 600, 1059, 1001, 1100}}, 5);
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        people = new boolean[schedules.length];

        // 날짜 계산
        for (int i = 0; i < 7; i++) {
            int day = (startday + i) % 7;
            if (day == 6 || day == 0) {
                continue;
            }

            findLatePeople(schedules, timelogs, i);
        }

        return prizePeople();
    }

    private static void findLatePeople(int[] schedules, int[][] timelogs, int index) {
        for (int i = 0; i < schedules.length; i++) {
            int lateCount = findLimitTime(schedules[i]);

            if (timelogs[i][index] > lateCount) {
                people[i] = true;
            }
        }
    }

    private static int findLimitTime(int schedule) {
        int hour = schedule / 100;
        int minute = schedule % 100 + 10;
        
        if (minute >= 60) {
            hour++;
            minute -= 60;
        }
        
        return hour * 100 + minute;
    }

    private static int prizePeople() {
        int cnt = 0;
        for (boolean pass : people) {
            if (!pass) {
                cnt++;
            }
        }
        return cnt;
    }
}
