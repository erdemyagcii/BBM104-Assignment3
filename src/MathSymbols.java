import java.util.ArrayList;

public class MathSymbols extends Holder implements IDiamond, ISquare, ITriangle{
    MathSymbols(String symbol){
        setLetter(symbol);
        setValue(20);
    }

    @Override
    public ArrayList<Integer> scan(int x, int y, ArrayList<String> jeweleries) {
        jeweleries = Command.mathSymbols;
        if(this.getLetter().equals("/"))
            return IDiamond.super.RightDiagonal(x, y, jeweleries);
        else if(this.getLetter().equals("-"))
            return ISquare.super.scan(x, y, jeweleries);
        else if(this.getLetter().equals("+")){
            if(ISquare.super.scan(x, y, jeweleries).size() != 0)
                return ISquare.super.scan(x, y, jeweleries);
            else
                return ITriangle.super.scan(x, y, jeweleries);
        }
        else if(this.getLetter().equals("\\"))
            return IDiamond.super.LeftDiagonal(x, y, jeweleries);
        else
            return ITriangle.super.scan(x, y, jeweleries);
    }
}
