import java.util.ArrayList;

public class Triangle extends Holder implements ITriangle {


    Triangle(String letter){
        setValue(15);
        setLetter(letter);
    }

    @Override
    public ArrayList<Integer> scan(int x, int y, ArrayList<String> jeweleries) {
        jeweleries.add("T");
        return ITriangle.super.scan(x, y, jeweleries);
    }
}

