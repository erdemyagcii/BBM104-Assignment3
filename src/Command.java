import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Command {

    static boolean warn = false; static int initialScore = 0;
    static ArrayList<String> mathSymbols; static ArrayList<String> jeweleries;

    static void ControlPanel() throws IOException {

        jeweleries = new ArrayList<>();
        mathSymbols = new ArrayList<>();

        Collections.addAll(mathSymbols, "/", "\\", "+", "-", "|");

        File file = new File(Main.commandPath);
        FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader);
        File file2 = new File("monitoring.txt");
        FileWriter fileWriter = new FileWriter(file2); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Game grid:\n\n");
        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++)
                bufferedWriter.write(Map.map[y][x].getLetter() + " ");
            bufferedWriter.write("\n");
        }
        bufferedWriter.write("\n");
        String line; String[] lineList;
        while(!(line = bufferedReader.readLine()).equals("E") ) {
            lineList = line.split(" ");
            bufferedWriter.write("Select coordinate or enter E to end the game: " + lineList[0] + " " + lineList[1] + "\n\n");
            try {
                Holder holder = Map.map[Integer.parseInt(lineList[0])][Integer.parseInt(lineList[1])];
            holder.Crush(holder.scan(Integer.parseInt(lineList[1]), Integer.parseInt(lineList[0]), jeweleries));
            }catch (IndexOutOfBoundsException e){
                warn = true;
            }
            if (!warn) {
                for (int y = 0; y < 10; y++) {
                    for (int x = 0; x < 10; x++)
                        bufferedWriter.write(Map.map[y][x].getLetter() + " ");
                    bufferedWriter.write("\n");
                }
                bufferedWriter.write("\n" + "Score: " + Command.initialScore + " points\n\n");
                Player.player.setScore(Player.player.getScore() + Command.initialScore); Command.initialScore  = 0;
            }
            else {
                warn = false;
                bufferedWriter.write("Please enter a valid coordinate\n\n");
            }
            jeweleries.clear();
        }
        bufferedWriter.write("Select coordinate or enter E to end the game: " + line + " " + "\n\n");
        bufferedWriter.write("Total score: " + Player.player.getScore() + " points\n\n");
        String name = bufferedReader.readLine();
        bufferedReader.close();
        bufferedWriter.write("Enter name: " + name + "\n\n");
        Player.player.setName(name);



        ArrayList<Player> nonSorted = new ArrayList<>(Player.players);
        Collections.sort(Player.players);
        int index = Player.players.indexOf(Player.player); int rank = index + 1;
        try {
            Player opponent1 = Player.players.get(index - 1); Player opponent2 = Player.players.get(index + 1);
            int diffrence1 = opponent1.getScore() - Player.player.getScore(); int diffrence2 = Player.player.getScore() - opponent2.getScore();
            bufferedWriter.write("Your rank is " + rank + "/" + Player.players.size() + ", your score is " + diffrence1 + " points lower than " + opponent1.getName() + " and " + diffrence2 + " point higher than " + opponent2.getName() +  "\n\n" + "Good bye!");
        }catch (IndexOutOfBoundsException e){
            if(index == 0) {
                Player oppponent = Player.players.get(index + 1); int diffrence = Player.player.getScore() - oppponent.getScore();
                bufferedWriter.write("Your rank is " + rank + "/" + Player.players.size() + ", your score is " + diffrence + " points higher than " + oppponent.getName() + "\n\n" + "Good bye!");
            }
            else if(index == Player.players.size() - 1){
                Player oppponent = Player.players.get(index - 1); int diffrence = oppponent.getScore() - Player.player.getScore();
                bufferedWriter.write("Your rank is " + rank + "/" + Player.players.size() + ", your score is " + diffrence + " points lower than " + oppponent.getName() + "\n\n" + "Good bye!");
            }
        }
        bufferedWriter.close();



        File file3 = new File("leaderboard.txt");
        FileWriter fileWriter2 = new FileWriter(file3); BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
        for(Player i:nonSorted)
            bufferedWriter2.write( i.getName() + " " + i.getScore() + "\n");
        bufferedWriter2.close();
    }
}