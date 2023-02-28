import java.util.ArrayList;
import java.util.Collections;


public interface IDiamond {

    default ArrayList<Integer> LeftDiagonal(int x, int y, ArrayList<String> jeweleries) {
        boolean Mark = true; ArrayList<Integer> willBeDeleted = new ArrayList<>(); String letter;
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

        Collections.addAll(willBeDeleted, x, y, x - 1, y - 1, x - 2, y - 2);
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
            Collections.addAll(willBeDeleted, x, y, x + 1, y + 1, x + 2, y + 2);
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

    default ArrayList<Integer> RightDiagonal(int x, int y, ArrayList<String> jeweleries) {
        boolean Mark = true; ArrayList<Integer> willBeDeleted = new ArrayList<>(); String letter;
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

        Collections.addAll(willBeDeleted, x, y, x + 1, y - 1, x + 2, y - 2);
        try {
            for (int i = 0; i < 6; i += 2) {
                if (!jeweleries.contains(Map.map[willBeDeleted.get(i + 1)][willBeDeleted.get(i)].getLetter())) {
                    willBeDeleted.clear(); Mark = false;
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            willBeDeleted.clear();
            Mark = false;
        }
        if (!Mark) {
            Collections.addAll(willBeDeleted, x, y, x - 1, y + 1, x - 2, y + 2);
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

    default ArrayList<Integer> scan(int x, int y, ArrayList<String> jeweleries) {
        if(LeftDiagonal(x, y, jeweleries).size() != 0)
            return LeftDiagonal(x, y, jeweleries);
        else
            return RightDiagonal(x, y, jeweleries);
    }
}
