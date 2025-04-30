import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static Map<String, List<String>> reportUser = new HashMap<>();
    static Map<String, Integer> reportedUser = new HashMap<>();
    static Map<String, Integer> result = new HashMap<>();

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        reportUsers(report);

        for (String s : id_list) {
            if (reportedUser.containsKey(s)) {
                if (reportedUser.get(s) >= k) {
                    makeResult(s);
                }
            }
        }

        for(int i = 0; i<id_list.length; i++) {
            answer[i] = result.getOrDefault(id_list[i], 0);
        }

        return answer;
    }

    private static void makeResult(String name) {
        for(String key : reportUser.keySet()) {
            if(reportUser.get(key).contains(name)) {
                result.put(key, result.getOrDefault(key, 0) + 1);
            }
        }
    }

    private static void reportUsers(String[] report) {
        for (String nameSet : report) {
            String[] splitName = splitName(nameSet);
            if (!reportUser.containsKey(splitName[0])) {
                reportUser.put(splitName[0], new ArrayList<>());
            }

            if(!reportUser.get(splitName[0]).contains(splitName[1])) {
                reportUser.get(splitName[0])
                        .add(splitName[1]);
                reportedUser.put(splitName[1], reportedUser.getOrDefault(splitName[1], 0) + 1);
            }
        }
    }

    private static String[] splitName(String nameSet) {
        return nameSet.split(" ");
    }
}
