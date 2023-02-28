import java.util.ArrayList;
import java.util.Collections;

public class WildCard extends Holder implements IDiamond, ISquare, ITriangle{

    WildCard(String letter){
        setValue(10);
        setLetter(letter);
    }

    @Override
    public ArrayList<Integer> scan(int x, int y, ArrayList<String> jeweleries) {
        ArrayList<Integer> willBeDeleted = new ArrayList<>();
        while (true) {
            try {
                Collections.addAll(jeweleries, "W", Map.map[y + 1][x].getLetter(), Map.map[y + 2][x].getLetter());
                if (jeweleries.get(1).equals(jeweleries.get(2))) {
                    Command.warn = false;
                    willBeDeleted = ITriangle.super.scan(x, y, jeweleries);}
                else if (!jeweleries.get(1).equals(jeweleries.get(2)) && jeweleries.get(2).equals("W")){
                    Command.warn = false;
                    willBeDeleted = ITriangle.super.scan(x, y, jeweleries);}
                else if (jeweleries.get(0).equals(jeweleries.get(1)) && !jeweleries.get(2).equals("W")) {
                    Command.warn = false;
                    willBeDeleted = ITriangle.super.scan(x, y, jeweleries);}
                if (willBeDeleted.size() != 0)
                    break;
            }catch (IndexOutOfBoundsException e){
                Command.warn = true;
            }

            jeweleries.clear();
            try {
            Collections.addAll(jeweleries, "W", Map.map[y - 1][x].getLetter(), Map.map[y - 2][x].getLetter());
            if(jeweleries.get(1).equals(jeweleries.get(2))) {
                Command.warn = false;
                willBeDeleted =  ITriangle.super.scan(x, y, jeweleries);}
            else if(!jeweleries.get(1).equals(jeweleries.get(2)) && jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  ITriangle.super.scan(x, y, jeweleries);}
            else if(jeweleries.get(0).equals(jeweleries.get(1)) && !jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  ITriangle.super.scan(x, y, jeweleries);}
            if(willBeDeleted.size() != 0)
                break;
            }catch (IndexOutOfBoundsException e){
                Command.warn = true;
            }

            jeweleries.clear();
            try {
            Collections.addAll(jeweleries, "W", Map.map[y][x - 1].getLetter(), Map.map[y][x - 2].getLetter());
            if(jeweleries.get(1).equals(jeweleries.get(2))) {
                Command.warn = false;
                willBeDeleted =  ISquare.super.scan(x, y, jeweleries);}
            else if(!jeweleries.get(1).equals(jeweleries.get(2)) && jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  ISquare.super.scan(x, y, jeweleries);}
            else if(jeweleries.get(0).equals(jeweleries.get(1)) && !jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  ISquare.super.scan(x, y, jeweleries);}
            if(willBeDeleted.size() != 0)
                break;
            }catch (IndexOutOfBoundsException e){
                Command.warn = true;
            }

            jeweleries.clear();

            try {
            Collections.addAll(jeweleries, "W", Map.map[y][x + 1].getLetter(), Map.map[y][x + 2].getLetter());
            if(jeweleries.get(1).equals(jeweleries.get(2))) {
                Command.warn = false;
                willBeDeleted =  ISquare.super.scan(x, y, jeweleries);}
            else if(!jeweleries.get(1).equals(jeweleries.get(2)) && jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  ISquare.super.scan(x, y, jeweleries);}
            else if(jeweleries.get(0).equals(jeweleries.get(1)) && !jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  ISquare.super.scan(x, y, jeweleries);}
            if(willBeDeleted.size() != 0)
                break;
            }catch (IndexOutOfBoundsException e){
                Command.warn = true;
            }


            jeweleries.clear();
            try {
            Collections.addAll(jeweleries, "W", Map.map[y - 1][x - 1].getLetter(), Map.map[y - 2][x - 2].getLetter());
            if(jeweleries.get(1).equals(jeweleries.get(2))) {
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            else if(!jeweleries.get(1).equals(jeweleries.get(2)) && jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            else if(jeweleries.get(0).equals(jeweleries.get(1)) && !jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            if(willBeDeleted.size() != 0)
                break;
            }catch (IndexOutOfBoundsException e){
                Command.warn = true;
            }


            jeweleries.clear();
            try{
            Collections.addAll(jeweleries, "W", Map.map[y + 1][x + 1].getLetter(), Map.map[y + 2][x + 2].getLetter());
            if(jeweleries.get(1).equals(jeweleries.get(2))) {
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            else if(!jeweleries.get(1).equals(jeweleries.get(2)) && jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            else if(jeweleries.get(0).equals(jeweleries.get(1)) && !jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            if(willBeDeleted.size() != 0)
                break;
            }catch (IndexOutOfBoundsException e){
                Command.warn = true;
            }

            jeweleries.clear();
            try{
            Collections.addAll(jeweleries, "W", Map.map[y - 1][x + 1].getLetter(), Map.map[y - 2][x + 2].getLetter());
            if(jeweleries.get(1).equals(jeweleries.get(2))) {
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            else if(!jeweleries.get(1).equals(jeweleries.get(2)) && jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            else if(jeweleries.get(0).equals(jeweleries.get(1)) && !jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            if(willBeDeleted.size() != 0)
                break;
            }catch (IndexOutOfBoundsException e){
                Command.warn = true;
            }

            jeweleries.clear();
            try{
            Collections.addAll(jeweleries, "W", Map.map[y + 1][x - 1].getLetter(), Map.map[y + 2][x - 2].getLetter());
            if(jeweleries.get(1).equals(jeweleries.get(2))) {
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            else if(!jeweleries.get(1).equals(jeweleries.get(2)) && jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            else if(jeweleries.get(0).equals(jeweleries.get(1)) && !jeweleries.get(2).equals("W")){
                Command.warn = false;
                willBeDeleted =  IDiamond.super.scan(x, y, jeweleries);}
            }catch (IndexOutOfBoundsException e){
                Command.warn = true;
            }
            break;
        }
        return willBeDeleted;
    }
}
