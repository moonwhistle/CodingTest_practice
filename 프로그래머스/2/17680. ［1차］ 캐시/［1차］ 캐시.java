import java.util.*;

class Solution {
    // 리스트와 인덱스 관리
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>(); 
        Map<String, Integer> map = new HashMap<>(); 
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(String city : cities) {
            String c = city.toLowerCase();
            
            if(list.contains(c)) { // 캐시에 있는 경우
                answer++;
                int idx = map.get(c);
                list.remove(idx);
                list.add(c);
            } else if(list.size() < cacheSize) { // 캐시에 없고, 캐시가 안 찬 경우
                list.add(c);
                answer += 5;
            } else { // 캐시에 없고, 캐시가 다 찬 경우
                list.remove(0);
                list.add(c);
                answer += 5;
            }    
            
            
            // index mapping
            for(int i = 0 ; i< list.size(); i++) {
                map.put(list.get(i), i);
            }
        }
        
        return answer;
    }
}