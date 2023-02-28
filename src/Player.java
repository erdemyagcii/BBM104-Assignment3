import java.io.*;
import java.util.ArrayList;

public class Player implements Comparable<Player>{

    @Override
    public int compareTo(Player o) {
        return  o.getScore() - this.getScore();
    }

    private int score;  private String name;
    static Player player;   static ArrayList<Player> players = new ArrayList<>();

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }


    static void CreatePlayers() throws IOException {
        File file = new File("leaderboard.txt");
        FileReader fileReader = new FileReader(file);   BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;    String[] lineList;
        while((line = bufferedReader.readLine()) != null) {
            lineList = line.split(" ");
            players.add(new Player(lineList[0], Integer.parseInt(lineList[1])));
        }
        players.add(Player.player = new Player("temporaryName", 0));
        bufferedReader.close();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
