import java.io.*;

public class Map {
    static Holder[][] map;

    static void CreateMap() throws IOException {
        File file = new File(Main.mapPath);
        File file2 = new File(Main.mapPath);
        FileReader fileReader1 = new FileReader(file);   BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        FileReader fileReader2 = new FileReader(file2); BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        String line;    String[] lineList;
        int rowCount = 0; int columnCount = 0;
        while((line = bufferedReader1.readLine()) != null){
            lineList = line.split(" ");
            rowCount += 1;
            if(columnCount == 0)
                columnCount = lineList.length;
        }
        bufferedReader1.close();

        map = new Holder[rowCount][columnCount];
        int y = 0;
        while((line = bufferedReader2.readLine()) != null && y < rowCount){
            lineList = line.split(" ");
            for(int x = 0; x < 10; x++) {
                if (lineList[x].equals("D"))
                    Map.map[y][x] = new Diamond("D");
                else if (lineList[x].equals("S"))
                     Map.map[y][x] = new Square("S");
                else if (lineList[x].equals("T"))
                    Map.map[y][x] = new Triangle("T");
                else if (lineList[x].equals("W"))
                    Map.map[y][x] = new WildCard("W");
                else
                    Map.map[y][x] = new MathSymbols(lineList[x]);
            }
            y += 1;
        }
        bufferedReader2.close();
    }
}
