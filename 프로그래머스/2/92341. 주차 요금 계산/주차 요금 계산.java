
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;

class Solution {

    static Map<String, Stack<String>> record = new HashMap<>();
    static Map<String, Integer> timeRecord = new TreeMap<>();

    public static int[] solution(int[] fees, String[] records) {
        calculateCarMinutes(records);
        int[] answer = new int[timeRecord.size()];

        int idx = 0;
        for(int i : timeRecord.values()) {
            answer[idx] = calculateTimePrice(fees, i);
            idx++;
        }

        return answer;
    }

    private static void calculateCarMinutes(String[] records) {
        for (String recordElement : records) {
            String[] splitRecord = recordParser(recordElement);
            String carNumber = splitRecord[1];

            if (Objects.equals(splitRecord[2], "IN")) {
                if (!record.containsKey(carNumber)) {
                    record.put(carNumber, new Stack<>());
                }
                record.get(carNumber)
                        .push(splitRecord[0]);
            } else {
                String inTime = record.get(carNumber)
                                .pop();
                int duration = changeTimeToMinutes(splitRecord[0]) - changeTimeToMinutes(inTime);
                timeRecord.put(carNumber, timeRecord.getOrDefault(carNumber, 0) + duration);
            }
        }
        lastOutCar();
    }

    private static void lastOutCar() {
        for(String carNumber : record.keySet()) {
            if(!record.get(carNumber)
                    .isEmpty()) {
                int duration = changeTimeToMinutes("23:59") - changeTimeToMinutes(record.get(carNumber).pop());
                timeRecord.put(carNumber, timeRecord.getOrDefault(carNumber, 0) + duration);
            }
        }
    }

    private static int calculateTimePrice(int[] fees, int totalMinutes) {
        int basicTime = fees[0]; // 기본 시간
        int basicFee = fees[1];  // 기본 요금
        int unitTime = fees[2];  // 단위 시간
        int unitFee = fees[3];   // 단위 요금

        if (totalMinutes <= basicTime) {
            return basicFee;
        } else {
            int exceedingTime = totalMinutes - basicTime;
            int additionalFee = (int) Math.ceil((double) exceedingTime / unitTime) * unitFee;
            return basicFee + additionalFee;
        }
    }

    private static int changeTimeToMinutes(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }

    private static String[] recordParser(String record) {
        return record.split(" ");
    }
}
