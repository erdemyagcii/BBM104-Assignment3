import java.util.ArrayList;

public class Diamond extends Holder implements IDiamond{

    Diamond(String letter){
        setValue(30);
        setLetter(letter);
    }

    @Override
    public ArrayList<Integer> scan(int x, int y, ArrayList<String> jeweleries) {
        jeweleries.add("D");
        return IDiamond.super.scan(x, y, jeweleries);
    }
}

