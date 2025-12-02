import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 2];
        Arrays.fill(students, 1);

        for (int l : lost) {
            students[l]--;
        }

        for (int r : reserve) {
            students[r]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (students[i] > 1 && students[i - 1] < 1) {
                students[i]--;
                students[i - 1]++;
            } else if (students[i] > 1 && students[i + 1] < 1) {
                students[i]--;
                students[i + 1]++;
            }
        }

        for (int student : students) {
            if (student >= 1) {
                answer++;
            }
        }

        return answer - 2;
    }
}
