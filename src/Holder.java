import java.util.ArrayList;

abstract public class Holder {

    private int value;
    private String letter;

    void Crush(ArrayList<Integer> wilBeDeleted) {
        if (wilBeDeleted.size() != 0) {
            int firstY2; int lastY2;
            if(wilBeDeleted.get(1) > wilBeDeleted.get(5)) {
                firstY2 = wilBeDeleted.get(1); lastY2 = wilBeDeleted.get(1) - 1;
            }
            else{
                firstY2 = wilBeDeleted.get(5); lastY2 = wilBeDeleted.get(5) - 1;
            }
            for (int i = 0; i < 5; i += 2) {

                if(wilBeDeleted.get(0).equals(wilBeDeleted.get(2))) {
                    int x = wilBeDeleted.get(i); int firstY; int lastY;
                    firstY = firstY2 ; lastY = lastY2;
                    Map.map[firstY2][x].setLetter(" ");
                    Command.initialScore += Map.map[firstY2][x].getValue();
                    Map.map[firstY][x].setValue(0);
                    while (lastY > -1) {
                        Holder temporary = Map.map[firstY][x];  Map.map[firstY][x] = Map.map[lastY][x]; Map.map[lastY][x] = temporary;
                        firstY -= 1;
                        lastY -= 1;
                    }
                }
                else {
                    Map.map[wilBeDeleted.get(i + 1)][wilBeDeleted.get(i)].setLetter(" ");
                    Command.initialScore += Map.map[wilBeDeleted.get(i + 1)][wilBeDeleted.get(i)].getValue();
                    Map.map[wilBeDeleted.get(i + 1)][wilBeDeleted.get(i)].setValue(0);
                    int x = wilBeDeleted.get(i);    int firstY = wilBeDeleted.get(i + 1); int lastY = wilBeDeleted.get(i + 1) - 1;
                    while (lastY > -1) {
                        Holder temporary = Map.map[firstY][x]; Map.map[firstY][x] = Map.map[lastY][x]; Map.map[lastY][x] = temporary;
                        firstY -= 1;
                        lastY -= 1;
                    }
                }
            }
        }
    }

    abstract ArrayList<Integer> scan(int x, int y, ArrayList<String> jeweleries);

    public int getValue() {return value;}

    public void setValue(int value) {
        this.value = value;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

}
