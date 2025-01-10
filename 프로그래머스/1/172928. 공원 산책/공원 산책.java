public class Solution {

    static int[][] op = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[] start;
    static int[][] map;

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        setPark(park);

        for (String route : routes) {
            int[][] op = setOp(route);
            move(op);
        }
        answer = start;
        return answer;
    }

    private static void move(int[][] op) {
        int count = op[1][0];
        int dx = op[0][0];
        int dy = op[0][1];
        int x = start[0];
        int y = start[1];
        int strange = 0;

        for (int i = 0; i < count; i++) {
            x += dx;
            y += dy;

            if ((x > map.length - 1 || y > map[0].length - 1 || x < 0 || y < 0 || map[x][y] == 1)) {
                strange++;
                break;
            }
        }

        if (strange == 0) {
            start = new int[]{x, y};
        }
    }

    private static void setPark(String[] park) {
        map = new int[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            for (int k = 0; k < park[i].length(); k++) {
                if (park[i].charAt(k) == 'S') {
                    start = new int[]{i, k};
                }
                if (park[i].charAt(k) == 'O' || park[i].charAt(k) == 'S') {
                    map[i][k] = 0;
                } else {
                    map[i][k] = 1;
                }
            }
        }
    }

    private static int[][] setOp(String route) {
        int[] count = {Integer.parseInt(String.valueOf(route.charAt(2)))};

        if (route.startsWith("E")) {
            return new int[][]{op[0], count};
        }
        if (route.startsWith("S")) {
            return new int[][]{op[1], count};
        }

        if (route.startsWith("W")) {
            return new int[][]{op[2], count};
        }

        return new int[][]{op[3], count};
    }
}
