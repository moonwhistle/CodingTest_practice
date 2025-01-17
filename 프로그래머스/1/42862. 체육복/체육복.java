class Solution {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //세팅
        int[] student = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            student[i] = 1;
        }

        //여분
        for (int i : reserve) {
            student[i] = 2;
        }

        //잃어버림
        for (int i : lost) {
            student[i] -= 1;
        }

        //빌려주기
        for (int i = 1; i <= n; i++) {
            if (student[i] == 2) {
                if (i > 1 && student[i - 1] == 0) {
                    student[i] -= 1;
                    student[i - 1] += 1;
                } else if (i < n && student[i + 1] == 0) {
                    student[i] -= 1;
                    student[i + 1] += 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.println(student[i]);
            if (student[i] > 0) {
                answer++;
            }
        }

        return answer;
    }
}
