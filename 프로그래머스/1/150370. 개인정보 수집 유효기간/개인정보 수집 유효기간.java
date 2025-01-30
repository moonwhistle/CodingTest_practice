import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        int[] answer;
        // 세팅
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Map<String, Integer> termsPair = new HashMap<>();

        for (String term : terms) {
            List<String> pair = List.of(term.split(" "));
            termsPair.put(pair.get(0), Integer.valueOf(pair.get(1)));
        }
        //날짜 변환
        Date formatedToday = format.parse(today);

        List<Integer> over = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            List<String> privacy = List.of(privacies[i].split(" "));
            Date privacyDate = format.parse(privacy.get(0));
            //월을 더하기
            Calendar privacyCalender = Calendar.getInstance();
            privacyCalender.setTime(privacyDate);
            privacyCalender.add(Calendar.MONTH, termsPair.get(privacy.get(1)));
            String changedDate = format.format(privacyCalender.getTime());
            // 비교
            int compare = formatedToday.compareTo(format.parse(changedDate));
            if (compare >= 0) {
                over.add(i + 1);
            }
        }

        answer = new int[over.size()];
        for (int i = 0; i < over.size(); i++) {
            answer[i] = over.get(i);
        }

        return answer;
    }
}
