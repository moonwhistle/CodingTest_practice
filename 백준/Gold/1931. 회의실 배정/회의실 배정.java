import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int start = input.nextInt();
            int end = input.nextInt();

            rooms.add(new Room(start, end));
        }

        Collections.sort(rooms);

        int count = 1;
        Room pre = rooms.get(0);

        for (int i = 1; i < rooms.size(); i++) {
            if (rooms.get(i).start >= pre.end) {
                count++;

                pre = rooms.get(i);
            }
        }

        System.out.println(count);
    }
}

class Room implements Comparable<Room> {
    int start;
    int end;

    public Room(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }

        return this.end - o.end;
    }
}
