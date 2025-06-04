import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Solution {

    // 먼저 정해진 데이터의 작은 값을 찾아서 모음
    // 오름차순으로 정렬

    static List<int[]> selectedData = new ArrayList<>();

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;

        // 데이터 추출
        selectData(data, ext, val_ext);

        // 배열 크기 지정
        answer = new int[selectedData.size()][4];

        // 오름차순 정렬
        sortData(sort_by);

        // 배열로 변환
        for(int i = 0 ; i< selectedData.size(); i++) {
            answer[i] = selectedData.get(i);
        }

        return answer;
    }

    private static void sortData(String sort_by) {
        if(Objects.equals(sort_by, "code")) {
            selectedData.sort(Comparator.comparingInt(data -> data[0]));
        }

        if(Objects.equals(sort_by, "date")) {
            selectedData.sort(Comparator.comparingInt(data -> data[1]));
        }

        if(Objects.equals(sort_by, "maximum")) {
            selectedData.sort(Comparator.comparingInt(data -> data[2]));
        }

        if(Objects.equals(sort_by, "remain")) {
            selectedData.sort(Comparator.comparingInt(data -> data[3]));
        }
    }


    private static void selectData(int[][] data, String ext, int val_ext) {
        for(int[] element : data) {
            if(compareData(element, ext, val_ext)) {
                selectedData.add(element);
            }
        }
    }

    private static boolean compareData(int[] data, String ext, int val_ext) {
        if(Objects.equals(ext, "code")) {
            return compareNumber(data[0], val_ext);
        }

        if(Objects.equals(ext, "date")) {
            return compareNumber(data[1], val_ext);
        }

        if(Objects.equals(ext, "maximum")) {
            return compareNumber(data[2], val_ext);
        }

        if(Objects.equals(ext, "remain")) {
            return compareNumber(data[3], val_ext);
        }

        return false;
    }

    private static boolean compareNumber(int dataNumber, int val_ext) {
        return dataNumber < val_ext;
    }
}
