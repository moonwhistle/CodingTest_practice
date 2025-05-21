import java.util.Objects;

class Solution {

    static int videoSecond;
    static int posSecond;
    static int opStartSecond;
    static int opEndSecond;

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        setTimeSecond(video_len, pos, op_start, op_end);
        playVideo(commands);
        return changeSecondToMinutes();
    }

    private static String changeSecondToMinutes() {
        int minutes = posSecond / 60;
        int second = posSecond % 60;
        return String.format("%02d:%02d", minutes, second);
    }

    private static void playVideo(String[] commands) {
        for (String command : commands) {
            skipOpening();
            if (Objects.equals(command, "next")) {
                next();
            }
            if (Objects.equals(command, "prev")) {
                prev();
            }
            skipOpening();
        }
    }

    private static void skipOpening() {
        if (posSecond >= opStartSecond && posSecond <= opEndSecond) {
            posSecond = opEndSecond;
        }
    }

    private static void next() {
        if (videoSecond - posSecond < 10) {
            posSecond = videoSecond;
        } else {
            posSecond += 10;
        }
    }

    private static void prev() {
        if (posSecond <= 10) {
            posSecond = 0;
        } else {
            posSecond -= 10;
        }
    }

    private static void setTimeSecond(String video_len, String pos, String op_start, String op_end) {
        videoSecond = makeTimeSecond(video_len);
        posSecond = makeTimeSecond(pos);
        opStartSecond = makeTimeSecond(op_start);
        opEndSecond = makeTimeSecond(op_end);
    }

    private static int makeTimeSecond(String time) {
        String[] minuteAndSecond = time.split(":");
        return Integer.parseInt(minuteAndSecond[0]) * 60 + Integer.parseInt(minuteAndSecond[1]);
    }
}
