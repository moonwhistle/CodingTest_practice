class Solution {

    static boolean[] people;

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
