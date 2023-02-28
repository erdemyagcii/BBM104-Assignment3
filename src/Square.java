import java.util.ArrayList;

public class Square extends Holder implements ISquare{

    Square(String letter){
        setValue(15);
        setLetter(letter);
    }

    @Override
    public ArrayList<Integer> scan(int x, int y, ArrayList<String> jeweleries) {
        jeweleries.add("S");
        return ISquare.super.scan(x, y, jeweleries);
    }
}
