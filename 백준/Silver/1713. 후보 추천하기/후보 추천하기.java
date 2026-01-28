import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int count = input.nextInt();
        List<Photo> photos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int num = input.nextInt();
            Photo photo = new Photo(num, i);

            if (photos.contains(photo)) {
                for (Photo photoElement : photos) {
                    if (photoElement.equals(photo)) {
                        photoElement.addRecommend();
                    }
                }
            } else {
                if (photos.size() < N) {
                    photos.add(photo);
                } else {
                    photos.remove(0);
                    photos.add(photo);
                }
            }

            Collections.sort(photos);
        }

        List<Integer> result = new ArrayList<>();

        for (Photo photo : photos) {
            result.add(photo.num);
        }

        Collections.sort(result);

        for (int resultElement : result) {
            System.out.print(resultElement + " ");
        }
    }
}

class Photo implements Comparable<Photo> {

    int num;
    int recommendCount;
    int time;

    public Photo(int num, int time) {
        this.num = num;
        this.recommendCount = 1;
        this.time = time;
    }

    public void addRecommend() {
        this.recommendCount += 1;
    }

    @Override
    public int compareTo(Photo other) {
        if (recommendCount == other.recommendCount) {
            return Integer.compare(time, other.time);
        }

        return Integer.compare(recommendCount, other.recommendCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Photo)) {
            return false;
        }

        Photo photo = (Photo) other;

        return num == photo.num;
    }
}
