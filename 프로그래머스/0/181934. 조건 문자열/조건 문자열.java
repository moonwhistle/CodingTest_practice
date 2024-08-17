class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        String inceqEq = ineq + eq;
        switch (inceqEq) {
            case ">=":
                if (n >= m) {
                    answer = 1;
                    break;
                }
                break;
            case "<=":
                if (n <= m) {
                    answer = 1;
                    break;
                }
                break;
            case ">!":
                if (n > m) {
                    answer = 1;
                    break;
                }
                break;
            case "<!":
                if (n < m) {
                    answer = 1;
                    break;
                }
                break;
        }
        return answer;
    }
}