import java.util.ArrayList;
import java.util.List;

class Solution {

    // P의 좌표 값을 뽑아낸다.
    // P의 좌표 값을 2개씩 묶는다.
    // 거리를 비교하고 x, y 좌표 값에 따라 해당되는 X점이 있는지 파악한다.

    public static int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[places.length];
        int placeNum = 0;

        for (String[] place : places) {
            List<int[]> PCoordinate = new ArrayList<>();

            // 좌표값 만들기
            for (int i = 0; i < place.length; i++) {
                for (int j = 0; j < place[i].length(); j++) {
                    if (place[i].charAt(j) == 'P') {
                        PCoordinate.add(new int[]{i, j});
                    }
                }
            }

            if (isSeparated(PCoordinate, place)) {
                answer[placeNum] = 1;
            } else {
                answer[placeNum] = 0;
            }

            placeNum++;
        }

        return answer;
    }

    private static boolean isSeparated(List<int[]> PCoordinate, String[] place) {
        boolean isSeparated = true;

        for (int i = 0; i < PCoordinate.size() - 1; i++) {
            int[] firstCoordinate = PCoordinate.get(i);
            for (int j = i + 1; j < PCoordinate.size(); j++) {
                int[] secondCoordinate = PCoordinate.get(j);
                int distance = Math.abs(firstCoordinate[0] - secondCoordinate[0]) + Math.abs(firstCoordinate[1] - secondCoordinate[1]);

                if(distance > 2) {
                    continue;
                }

                if(distance == 1) {
                    return false;
                }

                // distance 가 2인 경우
                isSeparated = calculatePartition(firstCoordinate, secondCoordinate, place);

                if(!isSeparated) {
                    return false;
                }
            }
        }

        return isSeparated;
    }

    // P-P 좌표 계산 2인 경우
    // (세로) x = 0 y = -2 -> 기준이 되는 P의 x좌표 그대로, y좌표 +1 로 파티션 검증
    // (가로) x = -2 y = 0 -> 기준이 되는 P의 x좌표 +1, y좌표 0 으로 파티션 검증
    // (대각선) x= -1, y = -1 || x = 1 y = -1 || ~~ -> 대각선으로 파티션 있는지 검증
    private static boolean calculatePartition(int[] firstCoordinate, int[] secondCoordinate, String[] place) {
        // 세로
        if(firstCoordinate[0] - secondCoordinate[0] == -2) {
            return place[firstCoordinate[0] + 1].charAt(firstCoordinate[1]) == 'X';
        } else if (firstCoordinate[1] - secondCoordinate[1] == -2) { // 가로
            return place[firstCoordinate[0]].charAt(firstCoordinate[1] + 1) == 'X';
        } else { // 대각선
            return place[firstCoordinate[0]].charAt(secondCoordinate[1]) == 'X'
                    && place[secondCoordinate[0]].charAt(firstCoordinate[1]) == 'X';
        }
    }
}
