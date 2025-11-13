import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static Map<String, Integer> type = new HashMap<>();

    public int solution(String[][] clothes) {
        int answer = 1;
        addType(clothes);

        List<Integer> sizes = new ArrayList<>();

        for (String key : type.keySet()) {
            sizes.add(type.get(key) + 1);
        }

        for (int size : sizes) {
            answer *= size;
        }

        return answer - 1;
    }

    private void addType(String[][] clothes) {
        for (String[] cloth : clothes) {
            type.put(cloth[1], type.getOrDefault(cloth[1], 0) + 1);
        }
    }
}
