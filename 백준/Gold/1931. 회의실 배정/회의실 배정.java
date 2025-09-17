import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // setting
        int N = input.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int start = input.nextInt();
            int end = input.nextInt();

            rooms.add(new Room(start, end));
        }
        Collections.sort(rooms);

        // 순회하며, 앞 시간이 끝 시간 앞에 오면 count++
        int count = 1;
        Room previous = rooms.get(0);
        for (int i = 1; i < rooms.size(); i++) {
            Room current = rooms.get(i);

            if (previous.end <= current.start) {
                previous = current;
                count++;
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
    public int compareTo(Room other) {
        if (other.end == this.end) {
            return this.start - other.start;
        }
        return this.end - other.end;
    }
}
