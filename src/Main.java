import java.io.IOException;

public class Main {
    static String mapPath;
    static String commandPath;
    public static void main(String[] args) throws IOException {
        mapPath = args[0];
        commandPath = args[1];
        Player.CreatePlayers();
        Map.CreateMap();
        Command.ControlPanel();
    }
}
