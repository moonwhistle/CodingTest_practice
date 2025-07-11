import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[] failRate = calculateFailRate(N, stages);
        float[][] failOrder = makeOrder(N, failRate);

        for(int i = 0; i<N; i++) {
            answer[i] = (int) failOrder[i][0];
        }

        return answer;
    }

    private static float[][] makeOrder(int N, float[] failRate) {
        float[][] order = new float[N][2];
        for (int i = 0; i < N; i++) {
            order[i][0] = i+1; // 스테이지 번호
            order[i][1] = failRate[i+1]; // 실패율
        }

        Arrays.sort(order, (a,b) -> {
            int comp = Float.compare(b[1], a[1]); // 실패율 내림차순
            if (comp == 0) {
                return Float.compare(a[0], b[0]); // 스테이지 번호 오름차순
            }
            return comp;
        });

        return order;
    }


    private static float[] calculateFailRate(int N, int[] stages) {
        float[] failRate = new float[N + 1];
        int people = stages.length;

        for (int stage : stages) {
            if (stage > N) {
                continue;
            }

            failRate[stage]++;
        }

        for (int i = 1; i < failRate.length; i++) {
            int challengers = (int) failRate[i];

            if (people == 0) {
                failRate[i] = 0;
            } else {
                failRate[i] = challengers / (float) people;
                people -= challengers;
            }
        }

        return failRate;
    }


}
