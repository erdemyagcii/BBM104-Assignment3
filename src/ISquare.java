import java.util.ArrayList;
import java.util.Collections;

public interface ISquare {

    default ArrayList<Integer> scan(int x, int y, ArrayList<String> jeweleries) {
        boolean Mark = true;     ArrayList<Integer> willBeDeleted = new ArrayList<>();     String letter;
        try {
            letter = Map.map[y][x].getLetter();
        } catch (IndexOutOfBoundsException e) {
            Command.warn = true;
            return willBeDeleted;
        }
        if (letter.equals(" ")) {
            Command.warn = true;
            return willBeDeleted;
        }

        Collections.addAll(willBeDeleted, x, y, x - 1, y, x - 2, y);
        try {
            for (int i = 0; i < 6; i += 2) {
                if (!jeweleries.contains(Map.map[willBeDeleted.get(i + 1)][willBeDeleted.get(i)].getLetter())) {
                    willBeDeleted.clear(); Mark = false;
                    break;
                }

            }
        } catch (IndexOutOfBoundsException e) {
            willBeDeleted.clear(); Mark = false;
        }
        if (!Mark) {
            Collections.addAll(willBeDeleted, x, y, x + 1, y, x + 2, y);
            try {
                for (int i = 0; i < 6; i += 2) {
                    if (!jeweleries.contains(Map.map[willBeDeleted.get(i + 1)][willBeDeleted.get(i)].getLetter())) {
                            willBeDeleted.clear();
                            break;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                willBeDeleted.clear();
            }
        }
        return willBeDeleted;
    }
}
